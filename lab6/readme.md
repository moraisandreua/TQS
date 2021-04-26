## Exe 1
Na alínea e) e f) foi usada a aplicação desenvolvida no lab1, relativa ao Euromilhoes

### alínea e)
Coverage	is less than	80.0%
Duplicated Lines (%)	is greater than	3.0%
Maintainability Rating	is worse than	A
Reliability Rating	is worse than	A
Security Hotspots Reviewed	is less than	100%
Security Rating	is worse than	A


Segundo as quality gates do SonarScanner, a aplicação não passa a validação porque 
* Coverage (70.7) < 80%;
* Reliability (D) < A;
* Security Hotspots Reviewed (0.0) < 100

Contudo é possivel ver-se o  sinal de "Passed" no topo do overview.


### alínea f)

| Issue  | Problem Description | How to solve |
| ------------- | ------------- | ------------- |
| Bug | <<Save and re-use this "Random">>  | Criando uma variavel globar para poder ser usada em várias partes do código  |
| Vulnerability | None  | Not applicable  |
| Code Smell | 2h15m de trabalho devido a Code Smells encontrados  | Corrigindo os 25 alertas mostrados na dashboard |

## Exe 2

### alínea a)
O *technical debt found* indica a previsão de tempo necessário para uma pessoa resolver as issues identificadas pelo SonnarScanner.

### alínea b)
![corrigido](https://i.imgur.com/A4itKEV.png)