<script lang="ts">
    import { onMount } from "svelte";
    import { Container, Button, Col, Row } from "sveltestrap/src";
    import { Form, FormGroup, FormText, Input, Label } from "sveltestrap";

    let selectedStoreName = "";
    let stores: any = [];

    onMount(async () => {
        const response = await fetch(
            "http://localhost:8080/companies/1234/stores"
        );
        stores = await response.json();

        console.log(stores);
    });
</script>

<style>
</style>

<Container class="mt-4">
    <FormGroup>
        <Input type="select" bind:value={selectedStoreName}>
            <option value="">-- 店舗 --</option>
            {#each stores as store}
                <option value={store.id}>({store.code}) {store.name}</option>
            {/each}
        </Input>
    </FormGroup>
    {#if selectedStoreName}
        <p>店舗名: {selectedStoreName}</p>
    {/if}
</Container>
