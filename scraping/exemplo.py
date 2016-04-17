# coding=utf­8
from scraper import Scraper

scraper = Scraper()
url =  'http://www.tudogostoso.com.br/busca.php?q=ovo'
consulta = '//*[@class="listing"]//a[span[@class="photo-holder"]]/@href'
resultados = scraper.consultar(url, consulta)
for resultado in resultados:
    print 'http://www.tudogostoso.com.br%s'%resultado.encode('utf-8').strip()
