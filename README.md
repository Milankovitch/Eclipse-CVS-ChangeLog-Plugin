# Eclipse-CVS-ChangeLog-Plugin (Eclipse 4.41 compatible fork)

A fork of [adagioca/Eclipse-CVS-ChangeLog-Plugin](https://github.com/adagioca/Eclipse-CVS-ChangeLog-Plugin),
updated to build and run on Eclipse 4.41 with Java 21 or later.

The original project (https://code.google.com/a/eclipselabs.org/p/changelog/) is no longer available.

## Requirements

- Eclipse 4.41 (Java 21 or later)
- Eclipse CVS Client feature (not included in recent Eclipse packages;
  install it from the Eclipse release repository)

## Installation

The plug-in is not signed, so Eclipse will show a warning during installation.
Use **either** of the following methods, not both.

### Option 1: Update site (recommended)

1. In Eclipse, open **Help > Install New Software...**
2. Click **Add...** and enter this update site URL:

   https://milankovitch.github.io/Eclipse-CVS-ChangeLog-Plugin/

3. Select the latest **ChangeLog Plug-in (Eclipse 4.41 compatible fork)** and complete the wizard.
4. Restart Eclipse.

### Option 2: dropins

1. Download `changelog-dropins-x.y.z.zip` from the [Releases](../../releases) page.
2. Extract it and copy the `changelog` folder into Eclipse's `dropins` folder.
3. Restart Eclipse with `-clean` once.

## Changes from the original

- Updated the required execution environment to JavaSE-21
- Adjusted build settings for current Eclipse and JDK versions
- Replaced deprecated APIs (`ViewerSorter` -> `ViewerComparator`, `Date` -> `java.time`, `URL` constructor)
- Version bumped to 1.1.0

## Building from source

1. Import `org.eclipselabs.changelog` and `org.eclipselabs.changelog.feature` into an Eclipse workspace with PDE.
2. Install the Eclipse CVS Client feature so the CVS bundles are on the target platform.
3. Open `site.xml` in the update-site project and click **Build All**.

## License

Common Public License v1.0 (http://www.eclipse.org/legal/cpl-v10.html).
Copyright (c) John C. Landers. Modifications Copyright (c) Milankovitch.

---

# 日本語

[adagioca/Eclipse-CVS-ChangeLog-Plugin](https://github.com/adagioca/Eclipse-CVS-ChangeLog-Plugin) のフォークです。
Eclipse 4.41 と Java 21 以降でビルド・動作するように修正しています。

元のプロジェクト( https://code.google.com/a/eclipselabs.org/p/changelog )は、すでに閉鎖されています。

## 動作要件

- Eclipse 4.41(Java 21 以降)
- Eclipse CVS Client フィーチャー(最近のEclipseパッケージには含まれていないため、
  Eclipseのリリース用リポジトリからインストールしてください)

## インストール方法

このプラグインは署名されていないため、インストール時に警告が表示されます。
次のどちらか**一方**の方法でインストールしてください(両方は使わないでください)。

### 方法1: アップデートサイト(推奨)

1. Eclipse で **ヘルプ > 新規ソフトウェアのインストール...** を開きます。
2. **追加...** をクリックし、次のアップデートサイトのURLを入力します。

   https://milankovitch.github.io/Eclipse-CVS-ChangeLog-Plugin/

3. 最新の **ChangeLog Plug-in (Eclipse 4.41 compatible fork)** を選択して、ウィザードを進めます。
4. Eclipse を再起動します。

### 方法2: dropins

1. [Releases](../../releases) ページから `changelog-dropins-x.y.z.zip` をダウンロードします。
2. 展開して、`changelog` フォルダを Eclipse の `dropins` フォルダにコピーします。
3. 初回は `-clean` を付けて Eclipse を再起動します。

## 元のバージョンからの変更点

- 必要な実行環境を JavaSE-21 に更新
- 最新のEclipseとJDKに合わせて、ビルド設定を調整
- 非推奨APIを置き換え(`ViewerSorter` → `ViewerComparator`、`Date` → `java.time`、`URL` コンストラクター)
- バージョンを 1.1.0 に更新

## ソースからのビルド

1. PDE が使えるEclipseのワークスペースに、`org.eclipselabs.changelog` と
   `org.eclipselabs.changelog.feature` をインポートします。
2. Eclipse CVS Client フィーチャーをインストールして、CVS関連のバンドルを
   ターゲットプラットフォームに含めます。
3. update-site プロジェクトの `site.xml` を開き、**Build All** をクリックします。

## ライセンス

Common Public License v1.0(http://www.eclipse.org/legal/cpl-v10.html)。
Copyright (c) John C. Landers. 変更部分 Copyright (c) Milankovitch.
