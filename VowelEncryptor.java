public class VowelEncryptor {

	public String[] encrypt(String[] text) {
		
		StringBuilder sb[] = new StringBuilder[text.length];
		
		for(int i=0; i<text.length; i++){
			sb[i] = new StringBuilder(text[i]);
		}
		
		for(int i=0; i<text.length; i++){
			if(isOnlyVowels(sb[i])){
				continue;
			}
			removeVowels(sb[i]);
		}
		
		String ans[] = new String[text.length];
		
		for(int i=0; i<text.length; i++){
			ans[i] = (new String(sb[i])).replaceAll(" ", "");
		}
		return ans;
	}
	private Boolean isOnlyVowels(StringBuilder str){
		int flg=0;
		
		for(int i=0; i<str.length(); i++){
			if(str.charAt(i)=='a'||str.charAt(i)=='i'||str.charAt(i)=='u'||str.charAt(i)=='e'||str.charAt(i)=='o'){
				continue;
			}
			flg=1;
		}
		return flg==0?true:false;
	}
	private  void removeVowels(StringBuilder str){
		for(int i=0; i<str.length(); i++){
			if(!(str.charAt(i)=='a'||str.charAt(i)=='i'||str.charAt(i)=='u'||str.charAt(i)=='e'||str.charAt(i)=='o')){
				continue;
			}
			str.replace(i, i+1, " ");
		}
	}
}
