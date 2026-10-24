/*
 * Copyright (c) John C. Landers All rights reserved. This program and the accompanying materials are made available
 * under the terms of the Common Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * *****************************************************************************
 */
package org.eclipselabs.changelog;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

final class ChangeLogFilter extends ViewerFilter {

    private static final String SEPARATOR = "|";

    private final String author;

    private final Date fromDate;

    private final Date toDate;

    private final String comment;

    private final boolean isOr;

    public ChangeLogFilter(String author, String comment, Date fromDate, Date toDate, boolean isOr) {
        this.author = author;
        this.comment = comment;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.isOr = isOr;
    }

    public ChangeLogFilter(String filter) {
        String[] split = filter.split("\\" + SEPARATOR);
        this.author = split[0];
        this.comment = split[1];

        this.fromDate = split[2].length() > 0 ? parseDate(split[2], split[3], split[4]) : null;
        this.toDate = split[5].length() > 0 ? parseDate(split[5], split[6], split[7]) : null;

        this.isOr = Boolean.parseBoolean(split[8]);
    }

    /**
     * Creates a Date from the legacy stored format (year - 1900, zero-based month, day).
     */
    private static Date parseDate(String year, String month, String day) {
        LocalDate d = LocalDate.of(
                Integer.parseInt(year) + 1900,
                Integer.parseInt(month) + 1,
                Integer.parseInt(day));
        return Date.from(d.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Appends a Date in the legacy stored format "year-1900|zero-based month|day".
     * For null, appends empty fields.
     */
    private static void appendDate(StringBuilder sb, Date date) {
        if (date == null) {
            sb.append(SEPARATOR).append(SEPARATOR);
            return;
        }
        LocalDate d = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        sb.append(d.getYear() - 1900);
        sb.append(SEPARATOR);
        sb.append(d.getMonthValue() - 1);
        sb.append(SEPARATOR);
        sb.append(d.getDayOfMonth());
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();

        if (author != null) {
            ret.append(author);
        }
        ret.append(SEPARATOR);
        if (comment != null) {
            ret.append(comment);
        }
        ret.append(SEPARATOR);
        appendDate(ret, fromDate);
        ret.append(SEPARATOR);
        appendDate(ret, toDate);
        ret.append(SEPARATOR);
        ret.append(isOr);

        return ret.toString();
    }

    /**
     * @see ViewerFilter#select(Viewer, Object, Object)
     */
    @Override
    public boolean select(Viewer aviewer, Object parentElement, Object element) {
        if (element instanceof ChangeLogEntry) {
            ChangeLogEntry entry = (ChangeLogEntry) element;
            if (isOr) {
                //empty fields should be considered a non-match
                return (hasAuthor() && authorMatch(entry)) || (hasDate() && dateMatch(entry)) || (hasComment() && commentMatch(entry));
            }
            //"and" search
            //empty fields should be considered a match
            return (!hasAuthor() || authorMatch(entry)) && (!hasDate() || dateMatch(entry)) && (!hasComment() || commentMatch(entry));
        }
        return false;
    }

    protected boolean authorMatch(ChangeLogEntry entry) {
        return entry.getAuthor().equals(author);
    }

    protected boolean commentMatch(ChangeLogEntry entry) {
        return !(entry.getComment().toLowerCase().indexOf(comment.toLowerCase()) == -1);
    }

    protected boolean dateMatch(ChangeLogEntry entry) {
        boolean from = true;
        if (fromDate != null) {
            from = fromDate.before(entry.getDate());
        }
        boolean to = true;
        if (toDate != null) {
            to = toDate.after(entry.getDate());
        }
        return from && to;
    }

    protected boolean hasAuthor() {
        return !author.equals("");
    }

    protected boolean hasComment() {
        return !comment.equals("");
    }

    protected boolean hasDate() {
        return fromDate != null || toDate != null;
    }

    public String getAuthor() {
        return author;
    }

    public String getComment() {
        return comment;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public boolean isOr() {
        return isOr;
    }
}