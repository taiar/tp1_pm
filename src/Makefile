RELAT_DIR=./
DATA_DIR=data/
DIR=$(RELAT_DIR)$(DATA_DIR)

main: Tp1_pm.java
	javac Tp1_pm.java

run: main
	java Tp1_pm $(DIR)pesquisadores.txt $(DIR)grafo_pesquisadores.txt $(DIR)grafo_artigos_pesquisadores.txt $(DIR)grafo_citacoes.txt $(DIR)veiculos.txt $(DIR)artigos_veiculos.txt

clean:
	rm *.class ./EntradaESaida/*.class ./Pesquisadores/*.class ./VeiculosDePublicacao/*.class ./Utilitarios/*.class ./popularidade_pesquisador.txt ./fatorImpacto_veiculo.txt ./pontuacao_artigo.txt
