# Eclipse-CVS-ChangeLog-Plugin (Eclipse 4.41 compatible fork)

A fork of [adagioca/Eclipse-CVS-ChangeLog-Plugin](https://github.com/adagioca/Eclipse-CVS-ChangeLog-Plugin),
updated to build and run on Eclipse 4.41 with Java 21 or later.

The original project (https://code.google.com/a/eclipselabs.org/p/changelog/) is no longer available.

## Requirements

- Eclipse 4.41 (Java 21 or later)
- Eclipse CVS Client feature (not included in recent Eclipse packages;
  install it from the Eclipse release repository)

## Installation

1. In Eclipse, open **Help > Install New Software...**
2. Click **Add...** and enter this update site URL:

   https://milankovitch.github.io/Eclipse-CVS-ChangeLog-Plugin/

3. Select **ChangeLog Plug-in** and complete the wizard.
   The plug-in is not signed, so Eclipse will show a warning.
4. Restart Eclipse.

## Changes from the original

- Updated the required execution environment to JavaSE-21
- Adjusted build settings for current Eclipse and JDK versions
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

元のプロジェクト(https://code.google.com/a/eclipselabs.org/p/changelog/)は、すでに閉鎖されています。

## 動作要件

- Eclipse 4.41(Java 21 以降)
- Eclipse CVS Client フィーチャー(最近のEclipseパッケージには含まれていないため、
  Eclipseのリリース用リポジトリからインストールしてください)

## インストール方法

1. Eclipse で **ヘルプ > 新規ソフトウェアのインストール...** を開きます。
2. **追加...** をクリックし、次のアップデートサイトのURLを入力します。

   https://milankovitch.github.io/Eclipse-CVS-ChangeLog-Plugin/

3. **ChangeLog Plug-in** を選択して、ウィザードを進めます。
   このプラグインは署名されていないため、警告が表示されます。
4. Eclipse を再起動します。

## 元のバージョンからの変更点

- 必要な実行環境を JavaSE-21 に更新
- 最新のEclipseとJDKに合わせて、ビルド設定を調整
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