## プロジェクト構築

### node が入ってるか

```
node -v
```

### プロジェクト作成

```
npx degit sveltejs/template nsake
cd nsake // 以降は作成したプロジェクト内で実行
```

### TypeScript で開発する場合

```
node scripts/setupTypeScript.js
```

### 依存関係のインストール

```
npm install
```

### 開発環境の起動

```
npm run dev
```

ブラウザで http://localhost:5000 が開ければ OK  
コード変更がリアルタイムに反映されていく。

## SPA 対応

```
npm install svelte-spa-router
```

app.svelte のソース参照

## Chrome 拡張

### 「検証」の時に「Svelete」タブが増えて Svelete コンポーネントのまま見れる

https://chrome.google.com/webstore/detail/svelte-devtools/ckolcbmkjpjmangdbmnkpjigpkddpogn/related

## VSCode

### Svelete Plugin

https://marketplace.visualstudio.com/items?itemName=svelte.svelte-vscode

### エディタとしての設定

`{app}/.vscode/settings.json`
