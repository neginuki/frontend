## プロジェクト構築

### node が入ってるか 

```
node -v
```

### プロジェクト作成

```
npx degit sveltejs/template exsvelte
```

### 依存関係のインストール

```
npm install
```

### 開発環境の起動

```
npm run dev
```

ブラウザで http://localhost:5000 が開ければOK  
コード変更がリアルタイムに反映されていく。

## SPA対応

```
npm install svelte-spa-router
```

app.svelte のソース参照

## CSS

殺風景すぎるので、 `public/index.html` に以下追記
```
<link rel="stylesheet" href="https://unpkg.com/papercss@1.6.1/dist/paper.min.css">
```



## その他

1. VSCode の設定

`{app}/.vscode/settings.json
