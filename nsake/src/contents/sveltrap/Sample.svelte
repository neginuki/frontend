<script lang="ts">
    import { onMount } from "svelte";
    import { Container, Button, Col, Row } from "sveltestrap/src";
    import {
        Form,
        FormGroup,
        FormText,
        Input,
        CustomInput,
        Label,
    } from "sveltestrap";

    let stores: any = [];

    onMount(async () => {
        const response = await fetch(
            "http://localhost:8080/companies/1234/stores"
        );
        stores = await response.json();

        console.log(stores);
    });

    let companyId = null;
    let storeId = null;
    let startDate = null;
    let endDate = null;
    let statusCode = null;
</script>

<style>
</style>

<Container class="mt-4">
    <Row>
        <Col>
            <FormGroup>
                <Label>法人名</Label>
                <Input type="text" readonly value="(1234) ガッツリラーメン" />
            </FormGroup>
        </Col>
    </Row>
    <Row>
        <Col>
            <FormGroup>
                <Label>店舗</Label>
                <Input type="select" bind:value={storeId}>
                    <option value="">-- 指定してください --</option>
                    {#each stores as store}
                        <option value={store.id}>
                            ({store.code})
                            {store.name}
                        </option>
                    {/each}
                </Input>
            </FormGroup>
        </Col>
    </Row>
    <Row>
        <Col>
            <FormGroup>
                <Label>期間(開始日)</Label>
                <Input
                    bind:value={startDate}
                    type="date"
                    placeholder="開始日" />
            </FormGroup>
        </Col>
        <Col class="col-auto">～</Col>
        <Col>
            <FormGroup>
                <Label>期間(終了日)</Label>
                <Input bind:value={endDate} type="date" placeholder="終了日" />
            </FormGroup>
        </Col>
    </Row>
    <Row>
        <Col>
            <FormGroup>
                <Label>状態</Label>
                <CustomInput
                    on:change={(e) => (statusCode = e.currentTarget.value)}
                    type="radio"
                    id="status1"
                    value="status1"
                    name="status"
                    label="健康" />
                <CustomInput
                    bind:group={statusCode}
                    type="radio"
                    id="status2"
                    value="status1"
                    name="status"
                    label="超健康" />
                <CustomInput
                    bind:group={statusCode}
                    type="radio"
                    id="status3"
                    value="status1"
                    name="status"
                    label="無敵" />
            </FormGroup>
        </Col>
    </Row>
    <Row>
        <Col>
            <Button color="warning">登録</Button>
        </Col>
    </Row>
</Container>

<Container>
    <div>companyId: {companyId}</div>
    <div>storeId: {storeId}</div>
    <div>startDate: {startDate}</div>
    <div>endDate: {endDate}</div>
    <div>statusCode: {statusCode}</div>
</Container>
