# ahhCalc

Uma calculadora com interface gráfica feita em Java puro, usando Swing. Visual inspirado nas calculadoras de smartphone, com layout em grid e botões coloridos para diferenciar operadores, funções e números.

## Funcionalidades

- Operações básicas: adição, subtração, multiplicação e divisão
- Inversão de sinal (+/-)
- Cálculo de porcentagem (%)
- Botão "AC" para limpar tudo
- Remoção automática de casas decimais desnecessárias (ex: `4.0` vira `4`)
- Botão de raiz quadrada (√) já está na interface — lógica ainda em desenvolvimento

## Tecnologias

- Java (Swing / AWT)

## Estrutura do projeto

src/
├── main/
│ └── Main.java # Ponto de entrada da aplicação
└── calculadora/
└── Calculadora.java # Lógica e interface da calculadora


## Como executar

1. Clone o repositório:
```bash
   git clone https://github.com/guparaiso/Calculadora-ahhCalc-Java.git
```
2. Entre na pasta do projeto e compile:
```bash
   javac -d out src/main/Main.java src/calculadora/Calculadora.java
```
3. Execute:
```bash
   java -cp out main.Main
```

## Autor

Feito por [guparaiso](https://github.com/guparaiso)
