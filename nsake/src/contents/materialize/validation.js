import vest , { test, enforce } from "vest";

const validate = vest.create('NewUserForm', (formData) => {
    test('brewery_name', '必須です', () => {
        enforce(formData.brewery_name)
            .isNotEmpty();
    });

    test("brewery_name", "つかえません",   
        async () => {
            const response = await fetch(
                "http://localhost:8080/breweries/" + formData.brewery_name,
                {
                    method: "GET",
                    headers: {
                        Accept: "application/json",
                        "Content-Type": "application/json",
                    },
                }
            );

            console.log("okkkk");

            return response.status === 404 ? Promise.reject() : Promise.resolve();
        });

            

    //test('password', 'Must contain at least one digit', () => {
    //    enforce(formData.password)
    //        .matches(/(?=.*[0-9])/);
    //});
});

export default validate;