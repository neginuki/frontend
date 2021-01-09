<script>
    import { Select, SelectItem } from "carbon-components-svelte";

    let plan = "white";
</script>

<style>
</style>

<main>
    <h1>Carbon Sample</h1>

    <h5>{plan}</h5>
    <Select
        on:change={(val) => (plan = val)}
        labelText="店舗"
        selected={plan}
        size="xl">
        <SelectItem value="g10" text="上野店" />
        <SelectItem value="g90" text="浅草店" />
        <SelectItem value="g100" text="御徒町店" />
    </Select>
</main>
