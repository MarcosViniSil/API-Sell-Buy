# API-Sell-Buy
## API with objective simulater wallet CryptoCoins using historic buy and Sale.
### Class Diagram

```mermaid
classDiagram
  class User {
    -String name
    -String country
    -Historic historic
  }

  class Historic {
    -Number historicCode
    -Date dateAccess
    -sale[] sales
    -buy[] purchases 
  }
  class Sale {
    -Number saleCode
    -Number priceSell
    -Date dateSell
    -String currency
  }
  class Buy {
    -Number purchaseCode
    -Number priceBuy
    -Date dateBuy
    -String currency
  }

  User "1" *-- "1" Historic
  Historic "1" *-- "N" Sale
  Historic "1" *-- "N" Buy
```
## Public API'S that will be used
### API de Dados v3 <br/> 
`https://www.mercadobitcoin.com.br/api-doc/`
### Ciprand <br/> 
`https://github.com/polarspetroll/ciprand`
