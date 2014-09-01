default:
	pdflatex spec.tex
	pdflatex spec.tex  # Second time generates the table of contents with spec.out
publish:
	scp spec.pdf h2rashee@taurine.csclub.uwaterloo.ca:www/refScheduler/attachments
clean:
	rm *.aux
	rm *.log
	rm *.toc
	rm spec.out
