import React, { Component } from "react";
import BreweryList, { Brewery } from "./BreweryList";
import "./App.css";

class App extends Component {
  render() {
    const breweries: Brewery[] = [
      {
        breweryId: 1,
        breweryName: "飛喜露酒造",
        breweryNameKana: "ひろきしゅぞう",
        address: "どこかのあそこ",
      },
      {
        breweryId: 2,
        breweryName: "高木酒造",
        breweryNameKana: "たかぎしゅぞー",
        address: "やまがたのどっか",
      },
    ];

    return (
      <div>
        <BreweryList breweries={breweries} />
      </div>
    );
  }
}

export default App;
