# coding=utf­8
import urllib3
from lxml import html

url =  'http://www.tudogostoso.com.br/busca.php?q=tapioca'
consulta = '//*[@class="listing"]//a[span[@class="photo-holder"]]/@href'
http = urllib3.PoolManager()
resposta = http.request('GET', url)
documento = html.document_fromstring(resposta.data)
resultados = documento.xpath(consulta)
for resultado in resultados:
    print 'http://www.tudogostoso.com.br%s'%resultado.encode('utf-8').strip()
