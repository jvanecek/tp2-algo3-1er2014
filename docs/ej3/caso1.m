

A = load("ej3_ndesde1_nhasta100_k0_p1.txt");

n = A(:,1);
t = A(:,2);

plot( n, t, n, ((n+20)*30).^2, "-.");

title ("Tablero con p y k minimos");
xlabel ("n");
ylabel ("seg");
%axis([0,1,0,1e7]);axis "autox"; 
legend ("Algoritmo", "O(n^2)");

print -djpeg caso_uno.jpg
