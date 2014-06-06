function [n,t] = load_files_with_3_cols(files)

	n = [];
	t = [];
	
	for i = 1:length(files)
		[n_i,t_i] = textread( files{i,1}, "%d %d", "delimiter", " ", "headerlines", 1);

		n = [n;n_i];
		t = [t;t_i];
	endfor

endfunction
