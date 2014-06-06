

files = {};
j = 1;
files{j,1} = sprintf("ej3_ndesde%d_nhasta%d_k%d_p1.txt", 1, 100, 0);
 
[n,t] = load_files_with_2_cols(files);

plot( n, t, n, (n.*30).^2+5e5, "-.");

title ("Tablero con p y k minimos");
xlabel ("n");
ylabel ("seg");
%axis([0,1,0,1e7]);axis "autox"; 
legend ("k=0", "O(n^2)");

print -djpeg caso_uno.jpg

