# coding=utf­8
import urllib3
import json
import re

termo = raw_input('Informe o termo de pesquisa: ')
if len(termo) > 0:
	url =  "http://dicionario-aberto.net/search-json/" + termo
	http = urllib3.PoolManager()
	resposta = http.request('GET', url)
	conteudo = resposta.data
	try:
		dicionario = json.loads(conteudo)
		definicao = ''
		if 'entry' in dicionario:
			definicao = dicionario['entry']['sense'][0]['def']
		else:
			for entry in dicionario['superEntry']:
				definicao = definicao + entry['entry']['sense'][0]['def'] + '\n'
		compilador = re.compile(r'<[^>]+>')
		definicao = compilador.sub(' ', definicao)
		print definicao
	except Exception:
		print 'Nenhuma resposta'
