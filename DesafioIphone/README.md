## Diagrama de Classes (Domínio da API)
```mermaid
classDiagram
  class IReprodutorMusical {
    +play()
    +pause()
    +next()
    +previous()
    +volumeUp()
    +volumeDown()
  }

  class ReprodutorMusical {
    <<interface>> IReprodutorMusical
    +listarMusicas()
  }

  class AparelhoTelefonico {
    +fazerChamada()
    +receberChamada()
    +enviarMensagem()
    +receberMensagem()
  }

  class INavegadorInternet {
    +abrirURL()
    +fecharURL()
    +navegarParaFrente()
    +navegarParaTras()
  }

  class NavegadorInternet {
    <<interface>> INavegadorInternet
    +pesquisar()
  }

  class IPhone {
    +modelo: String
    +cor: String
    -reprodutorMusical: IReprodutorMusical
    -aparelhoTelefonico: IAparelhoTelefonico
    -navegadorInternet: INavegadorInternet
  }

  IPhone --|> ReprodutorMusical
  IPhone --|> AparelhoTelefonico
  IPhone --|> NavegadorInternet
```