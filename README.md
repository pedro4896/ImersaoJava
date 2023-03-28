<img width=100% src="https://capsule-render.vercel.app/api?type=waving&color=1A57B5&height=120&section=header"/>
<h1 align=center>Imersão Java - Alura <span><img height=60 title="Java" alt="Java" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" /></span></h1> 
<br>
<h3>DIA 1</h3>
<div align=center>
<a href="https://git.io/typing-svg"><img src="https://readme-typing-svg.herokuapp.com?font=Fira+Code&size=33&pause=1000&color=1A57B5&width=435&lines=CONSUMINDO+UMA+API;DE+FILMES+COM+JAVA!" alt="Typing SVG" /></a>
</div>
<p>
   Nessa etapa, utilizamos a API do IMDB para requisitar o endpoint que retorna os 250 melhores filmes. Para isso, usamos a classe HttpClient e a interface HttpRequest do pacote java.net, que nos permitem estabelecer conexões cliente-servidor e enviar requisições HTTP.
</p>

<p> Além disso, o código converte a string que representa a classificação (imDbRating) em um valor float usando o método Float.parseFloat() e arredonda o valor resultante usando o método Math.round(). Depois, exibe o número de estrelas correspondente à classificação arredondada usando o símbolo unicode da estrela.</p>

<br>
<div align= center>
   <img src="https://github.com/pedro4896/ImersaoJava/blob/main/Dia%201/resultado_dia1.png" widht="300px" alt="Saída do Terminal"/>
</div>
<h3>OBS: Para as estrelas renderizarem no terminal é preciso acionar o comando "chcp 65001" no terminal e posteriormente compilar o código!</h3>

<h3>Dia 2</h3>
<p>O código apresenta uma classe Java chamada "GeradoraDeFigurinhas" que é responsável por criar figurinhas a partir de uma imagem e um texto inserido pelo usuário. A classe utiliza a biblioteca padrão do Java para lidar com imagens e recursos de desenho em 2D.</p>

<p>A classe recebe como entrada dois InputStreams, um contendo a imagem original e outro contendo uma imagem de sobreposição com informações adicionais, além do nome do arquivo de saída e o texto que será adicionado na imagem. A partir dessas informações, a classe cria uma nova imagem com o mesmo tamanho da original, porém com uma altura maior para acomodar o texto.</p>

<p>Em seguida, a classe copia a imagem original para a nova imagem e adiciona a imagem de sobreposição na parte inferior da imagem. O texto é então adicionado na nova imagem utilizando uma fonte e cor pré-definidas e é centralizado na imagem. Além disso, é aplicado um efeito de "outline" no texto, que é desenhado utilizando uma linha preta mais grossa para dar um efeito de contorno.</p>

<p>Por fim, a nova imagem é salva em um arquivo de saída em formato PNG.</p>

<div align= center>
   <img src="https://github.com/pedro4896/ImersaoJava/blob/main/Dia%202/figurinhas/The%20Dark%20Knight.png" height="400px" alt="Saída do Terminal"/>

   <img src="https://github.com/pedro4896/ImersaoJava/blob/main/Dia%202/figurinhas/The%20Godfather.png" height="400px" alt="Saída do Terminal"/>
</div>
<img width=100% src="https://capsule-render.vercel.app/api?type=waving&color=1A57B5&height=120&section=footer"/>
