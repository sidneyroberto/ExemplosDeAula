# coding=utf­8
import urllib3
import lxml.html

class Scraper:
	
	def consultar(self, url, xpath):
		http = urllib3.PoolManager()
		resposta = http.request('GET', url)
		documento = lxml.html.document_fromstring(resposta.data)
		resultados = documento.xpath(xpath)
		return resultados

