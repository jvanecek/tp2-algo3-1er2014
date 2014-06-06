

files = {};
k = 25
n = 75
j = 1
files{j,1} = sprintf("ej3_kdesde%d_khasta%d_n%d_p1_sesgado.txt", 1, k, n);
 
[n,k,t] = load_files_with_3_cols(files);

plot( k, t, k, k.*8e4+4.5e6, "-." );

%title ("");
xlabel ("k");
ylabel ("seg");
%axis([0,1,0,1e7]);axis "autox"; 
legend ("n=100", "O(k)");

print -djpeg caso_tres_lineal.jpg

