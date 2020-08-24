import React, { FC } from "react";
export interface Brewery {
  breweryId: number;
  breweryName: string;
  breweryNameKana: string;
  address: string;
}
interface BreweryListProps {
  breweries: Brewery[];
}
const BreweryList: FC<BreweryListProps> = ({ breweries }) => (
  <>
    <table>
      <thead>
        <tr>
          <th />
          <th>ID</th>
          <th>蔵名</th>
          <th>かな</th>
          <th>住所</th>
        </tr>
      </thead>
      <tbody>
        {breweries.map((brewery) => (
          <tr key={brewery.breweryId}>
            <td>
              <button>削除</button>
            </td>
            <td>{brewery.breweryId}</td>
            <td>{brewery.breweryName}</td>
            <td>{brewery.breweryNameKana}</td>
            <td>{brewery.address}</td>
          </tr>
        ))}
      </tbody>
    </table>
  </>
);
export default BreweryList;
