

files = {};
j = 1;
for n = [25,50,75,100]
	files{j,1} = sprintf("ej3_kdesde%d_khasta%d_n%d_p1.txt", 1, 25, n);
	j = j + 1;
endfor
 
[n,k,t] = load_files_with_3_cols(files);

plot( k(n==25), t(n==25), "-+",
          k(n==50), t(n==50), "-o",
          k(n==75), t(n==75), "-*",
          k(n==100), t(n==100), "-x" );

title ("En funcion de k");
xlabel ("k");
ylabel ("seg");
%axis([0,1,0,1e7]);axis "autox"; 
legend ("n=25", "n=50", "n=75", "n=100");

print -djpeg caso_dos.jpg
