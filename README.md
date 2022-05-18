# Data App :3

- Sobre:

	É um algoritmo para análise de dados capaz de compreender dados na pasta Data/in escritos em arquivos ".dat" e colocar o resultado na pasta Data/out. 

- Formato de leitura: 

| Formato    	|  Exemplo   |
| -------    		|      --------	 |
| 001çCPFçNameçSalary     | 001ç1234567891234çDiegoç50000    |
| 002çCNPJçNameçBusiness Area   | 002ç2345675433444345çEduardoPereiraçRural  |
| 003çSale IDç[Item ID-Item Quantity-Item Price]çSalesman name   | 003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çRenato  |

- Capacidades:

| Somente arquivos ".dat" |✅| <br>
| Execução contínua |✅|<br>
| Executa arquivos novos em tempo real |✅|<br>
| Não processa arquivos já analisados |✅|<br>
| Suporte a arquivos com milhares de linhas |✅|<br>
| Acompanhe a % de dados processados |✅|<br>
| Testes |✅|<br>

- Para criar um executável execute o comando na pasta da aplicação utilizando o terminal: 
- `gradle build uberjar `

> Certifique-se de possuir as pastas Data/in e Data/out antes de executar o programa ou irá receber um aviso no terminal. <

- Para executar use comando no terminal: 
`java -jar DataApp.jar`

### Exemplo de saída:

• Amount of clients in the input file: 1000 <br>
• Amount of salesman in the input file: 2000 <br>
• ID of the most expensive sale: 5 <br>
• Worst salesman ever: name <br>


> Extra: Gere arquivos .dat para está aplicação em: https://github.com/fhfelipefh/DataGenerator
