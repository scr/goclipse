package com.googlecode.goclipse.editors;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.ui.editors.text.FileDocumentProvider;

public class GoSourceDocumentProvider extends FileDocumentProvider {

	protected IDocument createDocument(Object element) throws CoreException {
		System.out.println("*** Creating document for " + element.toString());
		IDocument document = super.createDocument(element);
		if (document != null) {
			IDocumentPartitioner partitioner =new FastPartitioner(
					new GoSourcePartitionScanner(),
					GoSourceConfiguration.KNOWN_CONTENT_TYPES);
			partitioner.connect(document);
			document.setDocumentPartitioner(partitioner);
		}
		return document;
	}
}