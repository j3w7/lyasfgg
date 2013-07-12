//package mcp.apps.wordnet
//
//import java.io.FileInputStream
//import java.util.Iterator
//import net.didion.jwnl.JWNL
//import net.didion.jwnl.data.IndexWord
//
///** A class to demonstrate the functionality of the JWNL package. */
//class Examples {
//	private val USAGE = "java Examples <properties file>";
//
//	var ACCOMPLISH : IndexWord
//	var DOG : IndexWord
//	var CAT : IndexWord 
//	var FUNNY : IndexWord
//	var DROLL : IndexWord
//	var MORPH_PHRASE = "running-away";
//
//	def Examples() = {
//		ACCOMPLISH = Dictionary.getInstance().getIndexWord(POS.VERB, "accomplish");
//
//		CAT = Dictionary.getInstance().lookupIndexWord(POS.NOUN, "cat");
//		FUNNY = Dictionary.getInstance().lookupIndexWord(POS.ADJECTIVE, "funny");
//		DROLL = Dictionary.getInstance().lookupIndexWord(POS.ADJECTIVE, "droll");
//	}
//
//	def go() = {
//		demonstrateMorphologicalAnalysis(MORPH_PHRASE);
//		demonstrateListOperation(ACCOMPLISH);
//		demonstrateTreeOperation(DOG);
//		demonstrateAsymmetricRelationshipOperation(DOG, CAT);
//		demonstrateSymmetricRelationshipOperation(FUNNY, DROLL);
//	}
//
//	private def  demonstrateMorphologicalAnalysis(String phrase) {
//		// "running-away" is kind of a hard case because it involves
//		// two words that are joined by a hyphen, and one of the words
//		// is not stemmed. So we have to both remove the hyphen and stem
//		// "running" before we get to an entry that is in WordNet
//		System.out.println("Base form for \"" + phrase + "\": " +
//		                   Dictionary.getInstance().lookupIndexWord(POS.VERB, phrase));
//	}
//
//	private def  demonstrateListOperation(IndexWord word)   {
//		// Get all of the hypernyms (parents) of the first sense of <var>word</var>
//		PointerTargetNodeList hypernyms = PointerUtils.getInstance().getDirectHypernyms(word.getSense(1));
//		System.out.println("Direct hypernyms of \"" + word.getLemma() + "\":");
//		hypernyms.print();
//	}
//
//	private def  demonstrateTreeOperation(IndexWord word)   {
//		// Get all the hyponyms (children) of the first sense of <var>word</var>
//		PointerTargetTree hyponyms = PointerUtils.getInstance().getHyponymTree(word.getSense(1));
//		System.out.println("Hyponyms of \"" + word.getLemma() + "\":");
//		hyponyms.print();
//	}
//
//	private def  demonstrateAsymmetricRelationshipOperation(IndexWord start, IndexWord end)   {
//		// Try to find a relationship between the first sense of <var>start</var> and the first sense of <var>end</var>
//		RelationshipList list = RelationshipFinder.getInstance().findRelationships(start.getSense(1), end.getSense(1), PointerType.HYPERNYM);
//		System.out.println("Hypernym relationship between \"" + start.getLemma() + "\" and \"" + end.getLemma() + "\":");
//		for (Iterator itr = list.iterator(); itr.hasNext();) {
//			((Relationship) itr.next()).getNodeList().print();
//		}
//		System.out.println("Common Parent Index: " + ((AsymmetricRelationship) list.get(0)).getCommonParentIndex());
//		System.out.println("Depth: " + ((Relationship) list.get(0)).getDepth());
//	}
//
//	private def  demonstrateSymmetricRelationshipOperation(IndexWord start, IndexWord end)   {
//		// find all synonyms that <var>start</var> and <var>end</var> have in common
//		RelationshipList list = RelationshipFinder.getInstance().findRelationships(start.getSense(1), end.getSense(1), PointerType.SIMILAR_TO);
//		System.out.println("Synonym relationship between \"" + start.getLemma() + "\" and \"" + end.getLemma() + "\":");
//		for (Iterator itr = list.iterator(); itr.hasNext();) {
//			((Relationship) itr.next()).getNodeList().print();
//		}
//		System.out.println("Depth: " + ((Relationship) list.get(0)).getDepth());
//	}
//}
//
//object Examples {
//
//	def main(args: Array[String]) {
//		if (args.length != 1) {
//			System.out.println(USAGE);
//			System.exit(-1);
//		}
//
//		val propsFile = args(0)
//			// initialize JWNL (this must be done before JWNL can be used)
//			JWNL.initialize(new FileInputStream(propsFile));
//			new Examples().go();
//
//	}
//}
