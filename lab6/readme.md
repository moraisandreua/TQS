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

No caso abaixo, correspondente ao Overalcode, não pude corrigir o codesmell que falta, porque o codigo era necessário.
![overview](https://i.imgur.com/RbKaYo8.png)

### alínea d)
Coverage:
![coverage](https://i.imgur.com/9TWorZw.png)

Lines to Cover:
![lines_to_cover](https://i.imgur.com/bQOByGN.png)

Uncovered Lines:
![uncovered_lines](https://i.imgur.com/My5mwU5.png)

Conditions:
![conditions](https://i.imgur.com/iN8QNS9.png)

Uncovered Conditions:
![uncovered_conditions](https://i.imgur.com/cGwn697.png)

## Exe 3

### alínea a)
![quality_gates](https://i.imgur.com/2rQgCVC.png)

Cognitive Complexity > 90 -> o codigo tem de ser clean o suficiente para que a manutençao por membros da equipa que não escreveram o código sejá mais fácil
Bugs > 5 -> se o código tiver mais de 5 Bugs então a probabilidade de serem encontradas falhas é grande
Condition Coverage < 70 - para garantir que uma grande quantidade de variaveis condicionais são testadas
Coverage < - é importante que haja uma grande quantidade de testes que se equipare ao codigo corrido
Duplicated Lines (%) > 50 - devemos garantir que código duplicado seja refactored
Technical Debt > 1h - 1h já é bastante tempo de refactoring e muitas vezes é preciso usar recursos humanos noutras tarefas
Unit Test Duration > 30s - 30s é muito tempo para esta aplicação
Unit Test Success (%) =100% -  os testes unitarios devem ter todos sucesso
Vulnerabilities =0 - sendo que é uma aplicação que mexe com a casa do utilizador, convém não existirem vulnerabilidades que coloquem em risco a casa do utilizador.

### alínea b)
**Long Class** (a maior class tem 2x mais linhas do que a 2ª class com mais linhas)
![long_class](https://i.imgur.com/5uFIbfP.png)

**Long Method** (o maior metodo tem mais de 40 linhas de codigo)
![long_method](https://i.imgur.com/JLnloqe.png)

**Temporary Fields** ("String retorno" apenas é precisa dentro da função)
![temporary_fields](https://i.imgur.com/QziwHvj.png)

**Comments** (Comentários excessivos e repetivos ao longo do ficheiro)
![comments](https://i.imgur.com/TEyzHRs.png)

Depois da análise,
* Foi aumentado em 6 o número de code smells
![code_smells](https://i.imgur.com/mKm3YRO.png)
![smells_detailed](https://i.imgur.com/SMsvFxH.png)

Como as alterações de comments e long methods/classes não tiveram efeito, decidi alterar as Quality Gates:
![quality_gate_change](https://i.imgur.com/DJy18Fz.png)

E o resultado final foi este:
![final_result](https://i.imgur.com/60nd7fl.png)

