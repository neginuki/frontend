<script>
  import Router from "svelte-spa-router";
  import Home from "./routes/home.svelte";
  import BreweryCreate from "./routes/brewery/create.svelte";
  import BreweryList from "./routes/brewery/list.svelte";
  import BreweryDetail from "./routes/brewery/detail.svelte";

  import { link } from "svelte-spa-router";

  const routes = {
    "/": Home,
    "/brewery/create": BreweryCreate,
    "/brewery/list": BreweryList,
    "/brewery/detail/:id": BreweryDetail
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
    <a href="#/brewery/create">蔵元作成</a>
    <a href="#/brewery/list">蔵元一覧</a>
  </div>

  <Router {routes} />
</body>
