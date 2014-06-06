function [n,k,t] = load_files_with_3_cols(files)

	n = [];
	k = [];
	t = [];
	
	for i = 1:length(files)
		[n_i,k_i,t_i] = textread( files{i,1}, "%d %d %d", "delimiter", " ", "headerlines", 1);

		n = [n;n_i];
		t = [t;t_i];
		k = [k;k_i];
	endfor

endfunction
