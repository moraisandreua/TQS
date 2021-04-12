# Exercício 1

AssertJ is a java library providing a rich set of assertions, truly helpful error messages, 
improves test code readability and is designed to be super easy to use within your favorite IDE.
## a)  Identify a couple of examples on the use of AssertJ expressive methods chaining.
* assertThat("The Lord of the Rings").isNotNull().startsWith("The").contains("Lord").endsWith("Rings");
* assertThat(frodo.getAge()).as("check %s's age", frodo.getName()).isEqualTo(100);
TolkienCharacter frodo = new TolkienCharacter("Frodo", 33, Race.HOBBIT);
* assertThat(frodo.getName()).as("check name").isEqualTo("Frodo");
* assertThat(frodo.getAge()).as("check age").isEqualTo(33);

## b) Identify an example in which you mock the behavior of the repository (and avoid involving a database)
* É util usar mock quando temos, por exemplo, quando a base de dados não está na máquina local porque a base de dados pode não estar disponível. Além de não corrermos o risco de apanharmos bugs que nos falsifiquem o teste. 
* Quantas mais dependências adicionamos ao teste, mais são as razões para o teste falhar.
* Os mocks também reduzem a complexidade portanto poupam tempo com quantidades de dados grandes.

## c) What is the difference between standard @Mock and @MockBean?
* Ambos criam objetos mock, mas com propósitos diferentes. 
* @Mock pertence à biblioteca do Mockito e permite verificar comportamentos no mock da classe criada.
* @Mock pertence *a biblioteca do springframework e permite adicionar mocks do Mockito ao ApplicationContext. Se um bean, compatível com aquele declarado existe no context, o springframework faz replace do bean pelo mock, caso contrário adiciona o mock ao context como sendo um bean.
* Em termos práticos, quando @MockBean é usado num cmapo, além de este ser registado no application context, o mick será também injetado no campo.

## d) What is the role of the file “application-integrationtest.properties”? In which conditions will it be used?
* Permite-nos definir properties a serem usadas nos testes de integração.
* Permite-nos fazer merges de properties com o ficheiro predefinido. Assim, podemos usar tanto as properties default como as properties de teste.
* Útil para quando queremos fazer override de multiplas properties de um ficheiro mas continuar a usar as properties default.
