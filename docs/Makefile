TARGET := Informe.pdf
MAIN := Informe.tex
OPTS := -interaction batchmode

.PHONY: all clean
all: $(TARGET)
clean:
	rm -f *.out *.aux *.toc *.log

$(TARGET): $(MAIN)
	pdflatex $(OPTS) $(MAIN)
	while `cat $(TARGET:.pdf=.log) | grep -qi rerun`; do pdflatex $(OPTS) $(MAIN); done

# Dependencias
$(TARGET): ej1.tex ej2.tex ej3.tex caratula.sty
