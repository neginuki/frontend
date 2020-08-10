<script>
  import Router from "svelte-spa-router";
  import Home from "./routes/home.svelte";
  import BrandCreate from "./routes/brand/create.svelte";
  import BrandList from "./routes/brand/list.svelte";

  import { link } from "svelte-spa-router";

  const routes = {
    "/": Home,
    "/brand/create": BrandCreate,
    "/brand/list": BrandList
  };
</script>

<style>
  div.menu a {
    margin-right: 10px;
  }
</style>

<body>
  <div class="menu">
    <a href="#/">#</a>
    <a href="#/brand/create">銘柄作成</a>
    <a href="#/brand/list">銘柄一覧</a>
  </div>

  <Router {routes} />
</body>
