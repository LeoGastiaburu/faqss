package faq.language;

import java.util.Hashtable;

public class Language {
	public static Hashtable<String, String> string = new Hashtable<String, String>();
	public static String lastest(String language) {
		string.put("en", "Latest Question");
		string.put("es", "últimas preguntas");
		string.put("de", "Aktuelle Frage");
		string.put("fr", "Dernières questions");
		string.put("hi", "नवीनतम प्रश्न");
		string.put("ja", "最新の質問");
		string.put("ko", "최근 질문");
		string.put("nl", "laatste vraag");
		string.put("pl", "Najnowsze Pytanie");
		string.put("pt", "Últimas Pergunta");
		string.put("ro", "ultima domanda");
		string.put("tr", "son soru");
		string.put("ru", "Последний вопрос");
		string.put("zh", "");
	    return (string.get(language) != null)?string.get(language):string.get("en");
    }
	public static String menu_home(String language) {		
		string.put("en", "Home page");
		string.put("es", "Portada del sitio");
		string.put("de", "Startseite");
		string.put("fr", "Page d'accueil");
		string.put("hi", "मुख पृष्ठ");
		string.put("ja", "ホームページ");
		string.put("ko", "홈페이지");
		string.put("nl", "Home page");
		string.put("pl", "Strona główna");
		string.put("pt", "Home page");
		string.put("ro", "Home page");
		string.put("tr", "Ana Sayfa");
		string.put("ru", "Главная страница");
		string.put("zh", "");
		return (string.get(language) != null)?string.get(language):string.get("en");
    }
	public static String menu_question(String language) {		
		string.put("en", "Question");
		string.put("es", "pregunta");
		string.put("de", "Frage");
		string.put("fr", "Question");
		string.put("hi", "सवाल");
		string.put("ja", "質問");
		string.put("ko", "문제");
		string.put("nl", "vraag");
		string.put("pl", "pytanie");
		string.put("pt", "pergunta");
		string.put("ro", "domanda");
		string.put("tr", "soru");
		string.put("ru", "вопрос");
		string.put("zh", "");
		return (string.get(language) != null)?string.get(language):string.get("en");
    }
	public static String menu_tag(String language) {		
		string.put("en", "Tags");
		string.put("es", "Tags");
		string.put("de", "Tags");
		string.put("fr", "Tags");
		string.put("hi", "टैग");
		string.put("ja", "タグ");
		string.put("ko", "태그");
		string.put("nl", "Tags");
		string.put("pl", "Tagi");
		string.put("pt", "Tags recentes");
		string.put("ro", "Tag");
		string.put("tr", "Etiketler");
		string.put("ru", "Теги");
		string.put("zh", "");
		return (string.get(language) != null)?string.get(language):string.get("en");
    }
	public static String menu_user(String language) {		
		string.put("en", "Users");
		string.put("es", "Los usuarios");
		string.put("de", "Benutzer");
		string.put("fr", "Utilisateurs");
		string.put("hi", "उपयोक्ता");
		string.put("ja", "ユーザー");
		string.put("ko", "사용자");
		string.put("nl", "Gebruikers");
		string.put("pl", "Użytkownicy");
		string.put("pt", "Usuários");
		string.put("ro", "Utenti");
		string.put("tr", "Kullanıcılar");
		string.put("ru", "Пользователи");
		string.put("zh", "");
		return (string.get(language) != null)?string.get(language):string.get("en");
    }
	public static String menu_contact(String language) {		
		string.put("en", "Contact");
		string.put("es", "Contacto");
		string.put("de", "Kontakt");
		string.put("fr", "Contact");
		string.put("hi", "संपर्क");
		string.put("ja", "お問い合わせ");
		string.put("ko", "접촉");
		string.put("nl", "Contact");
		string.put("pl", "Kontakt");
		string.put("pt", "Contato");
		string.put("ro", "Contatto");
		string.put("tr", "Temas");
		string.put("ru", "контакт");
		string.put("zh", "");
		return (string.get(language) != null)?string.get(language):string.get("en");
    }
	public static String recent_tag(String language) {		
		string.put("en", "Recent tags");
		string.put("es", "Etiquetas recientes");
		string.put("de", "Aktuelle Tags");
		string.put("fr", "Ces dernières balises");
		string.put("hi", "हाल टैग");
		string.put("ja", "最近のタグ");
		string.put("ko", "최근 태그");
		string.put("nl", "Recente tags");
		string.put("pl", "Najnowsze tagi");
		string.put("pt", "Tags recentes");
		string.put("ro", "Tag recenti");
		string.put("tr", "Son etiketler");
		string.put("ru", "Последние теги");
		string.put("zh", "");
		return (string.get(language) != null)?string.get(language):string.get("en");
    }
	public static String random_question(String language) {		
		string.put("en", "Random question");
		string.put("es", "Pregunta al azar");
		string.put("de", "Random Frage");
		string.put("fr", "Question aléatoire");
		string.put("hi", "यादृच्छिक सवाल");
		string.put("ja", "ランダム質問");
		string.put("ko", "랜덤 질문");
		string.put("nl", "Willekeurige vraag");
		string.put("pl", "Random pytanie");
		string.put("pt", "Pergunta aleatória");
		string.put("ro", "Domanda a caso");
		string.put("tr", "Rastgele soru");
		string.put("ru", "Случайный вопрос");
		string.put("zh", "");
		return (string.get(language) != null)?string.get(language):string.get("en");
    }
	public static String question_by(String language) {		
		string.put("en", "Question by");
		string.put("es", "Pregunta por");
		string.put("de", "Frage von");
		string.put("fr", "Question posée par");
		string.put("hi", "द्वारा प्रश्न");
		string.put("ja", "さんの質問");
		string.put("ko", "에 의해 질문");
		string.put("nl", "Vraag door");
		string.put("pl", "Pytanie:");
		string.put("pt", "Pergunta por");
		string.put("ro", "Domanda da");
		string.put("tr", "Tarafından soru");
		string.put("ru", "Вопрос по");
		string.put("zh", "");
		return (string.get(language) != null)?string.get(language):string.get("en");
    }
	public static String other_tag(String language) {		
		string.put("en", "Other tags");
		string.put("es", "Otras etiquetas");
		string.put("de", "Andere Tags");
		string.put("fr", "D'autres balises");
		string.put("hi", "अन्य टैग्स");
		string.put("ja", "その他のタグ");
		string.put("ko", "기타 태그");
		string.put("nl", "Andere tags");
		string.put("pl", "Inne tagi");
		string.put("pt", "Tags outras");
		string.put("ro", "Altri tag");
		string.put("tr", "Diğer etiketler");
		string.put("ru", "Другие теги");
		string.put("zh", "");
		return (string.get(language) != null)?string.get(language):string.get("en");
    }
	public static String anwer_by(String language) {		
		string.put("en", "Answer by");
		string.put("es", "Respuesta de");
		string.put("de", "Antwort von");
		string.put("fr", "Réponse par");
		string.put("hi", "द्वारा जवाब");
		string.put("ja", "で答える");
		string.put("ko", "의 답변");
		string.put("nl", "Antwoord van");
		string.put("pl", "Odpowiedz przez");
		string.put("pt", "Resposta por");
		string.put("ro", "Risposta da");
		string.put("tr", "Tarafından cevap");
		string.put("ru", "Ответ на");
		string.put("zh", "");
		return (string.get(language) != null)?string.get(language):string.get("en");
    }
	public static String taged(String language) {		
		string.put("en", "Tagged");
		string.put("es", "Etiquetado");
		string.put("de", "Tagged");
		string.put("fr", "Tagged");
		string.put("hi", "चिह्नित");
		string.put("ja", "タグ");
		string.put("ko", "태그");
		string.put("nl", "Tagged");
		string.put("pl", "Tagged");
		string.put("pt", "Tagged");
		string.put("ro", "Tagged");
		string.put("tr", "Takip edilen");
		string.put("ru", "меченый");
		string.put("zh", "");
		return (string.get(language) != null)?string.get(language):string.get("en");
    }
	public static String list_author(String language) {		
		string.put("en", "List author");
		string.put("es", "Lista de autores");
		string.put("de", "Verfasser der Liste");
		string.put("fr", "Auteur de la liste");
		string.put("hi", "सूची लेखक");
		string.put("ja", "リスト作成者");
		string.put("ko", "목록 작성자");
		string.put("nl", "Lijst auteur");
		string.put("pl", "Autor lista");
		string.put("pt", "Autor lista");
		string.put("ro", "Lista degli autori");
		string.put("tr", "Listesi yazar");
		string.put("ru", "Список автора");
		string.put("zh", "");
		return (string.get(language) != null)?string.get(language):string.get("en");
    }
	public static String list_tag(String language) {		
		string.put("en", "List tag");
		string.put("es", "Lista de etiquetas");
		string.put("de", "List-Tag");
		string.put("fr", "Liste tag");
		string.put("hi", "");
		string.put("ja", "");
		string.put("ko", "");
		string.put("nl", "");
		string.put("pl", "");
		string.put("pt", "");
		string.put("ro", "");
		string.put("tr", "");
		string.put("ru", "");
		string.put("zh", "");
		return (string.get(language) != null)?string.get(language):string.get("en");
    }
	public static String text_contact(String language) {		
		string.put("en", "If you have any questions, or comments and suggestions, please use the form below to contact us. Or you can mail to contact [at] gardenquestions.com .");
		string.put("es", "Si usted tiene alguna pregunta o comentarios y sugerencias, por favor utilice el siguiente formulario para contactar con nosotros. O puede enviar por correo a contact [at] gardenquestions.com.");
		string.put("de", "Wenn Sie Fragen oder Kommentare und Anregungen haben, nutzen Sie bitte das unten stehende Formular Kontakt mit uns auf. Oder Sie können E-Mail an [at] gardenquestions.com kontaktieren.");
		string.put("fr", "Si vous avez des questions ou des commentaires et des suggestions, s'il vous plaît utilisez le formulaire ci-dessous pour nous contacter. Ou vous pouvez envoyer un mail à contact [at] gardenquestions.com.");
		string.put("hi", "यदि आप कोई प्रश्न हैं, या टिप्पणियाँ और सुझाव दिया है, नीचे के फार्म का उपयोग करने के लिए हमसे संपर्क करें. या फिर आप को gardenquestions.com [पर] संपर्क मेल कर सकते हैं.");
		string.put("ja", "ご質問、またはコメントや提案がある場合は、お問い合わせは下記フォームをご利用ください。または、gardenquestions.com[at]を連絡先にメールができます。");
		string.put("ko", "의문 사항이나 의견과 제안이 있으시면 문의 아래의 양식을 사용하시기 바랍니다. 아니면 gardenquestions.com [에에서] 문의 메일하실 수 있습니다.");
		string.put("nl", "Als u nog vragen of opmerkingen en suggesties, gebruik dan het formulier hieronder om ons te contacteren. Of u kunt mailen naar contact [at] gardenquestions.com.");
		string.put("pl", "Jeśli masz jakiekolwiek pytania lub uwagi i sugestie, skorzystaj z poniższego formularza do kontaktu z nami. Możesz mail do kontaktu [at] gardenquestions.com.");
		string.put("pt", "Se você tiver alguma dúvida, ou comentários e sugestões, por favor use o formulário abaixo para entrar em contato conosco. Ou você pode enviar para contact [at] gardenquestions.com.");
		string.put("ro", "Se avete domande o commenti e suggerimenti, potete utilizzare il modulo qui sotto per contattarci. Oppure si può mail al contatto [at] gardenquestions.com.");
		string.put("tr", "Herhangi bir sorunuz ya da yorum ve önerileriniz varsa, bize aşağıdaki formu kullanın. Yoksa gardenquestions.com [at] iletişim için e-posta gönderebilirsiniz.Listen Read phonetically");
		string.put("ru", "Если у вас есть какие-либо вопросы или замечания и предложения, пожалуйста, используйте форму ниже, чтобы связаться с нами. Или вы можете отправить по почте связаться с [в] gardenquestions.com.");
		string.put("zh", "");
		return (string.get(language) != null)?string.get(language):string.get("en");
    }
	public static String footer(String language) {		
		string.put("en", "stackexchange.com public data dump and are licensed under the cc-wiki license.Logo, design and layout © 2011");
		string.put("es", "datos stackexchange.com público volcado y están registrados bajo la cc-wiki license.Logo, diseño y maquetación © 2011");
		string.put("de", "stackexchange.com öffentlichen Daten-Dump und sind unter der cc-wiki license.Logo, Design und Layout © 2011 lizenziert");
		string.put("fr", "des données publiques stackexchange.com dump et sont sous licence cc-wiki license.Logo, conception et mise en page © 2011");
		string.put("hi", "stackexchange.com सार्वजनिक डेटा डंप कर रहे हैं और cc-wiki license.Logo, डिजाइन और 2011 © लेआउट के अंतर्गत लाइसेंस");
		string.put("ja", "stackexchange.com公開データは、ダンプとcc- wikiのlicense.Logo、デザインやレイアウト© 2010の下でライセンスされています");
		string.put("ko", "stackexchange.com 공개 데이터 덤프 및 CC - 위키 license.Logo, 디자인 및 레이아웃 © 2011 이하 라이센스");
		string.put("nl", "stackexchange.com openbare gegevens dump en zijn gelicenseerd onder de cc-wiki license.Logo, ontwerp en lay-out © 2011");
		string.put("pl", "stackexchange.com danych publicznych dump i są licencjonowane pod licencją cc-wiki, license.Logo projektu i układu © 2011");
		string.put("pt", "dados stackexchange.com pública despejo e estão licenciadas sob o cc-wiki license.Logo design e layout © 2011");
		string.put("ro", "dati stackexchange.com pubblico dump e sono sotto licenza CC-wiki license.Logo, il design e il layout © 2011");
		string.put("tr", "stackexchange.com kamu veri dökümü ve cc-wiki license.Logo, tasarım ve düzen © 2011 altında lisanslanır");
		string.put("ru", "stackexchange.com публичных данных свалку и распространяется на условиях лицензии CC-вики license.Logo, дизайн и верстка © 2011");
		string.put("zh", "");
		return (string.get(language) != null)?string.get(language):string.get("en");
    }
}
