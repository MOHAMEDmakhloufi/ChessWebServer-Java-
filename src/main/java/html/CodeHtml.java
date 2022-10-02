package html;

import model.MyString;

import java.util.List;

public class CodeHtml {
    public static String getFinalHtmlCode(String cssFile, String... codes){
        String body="";
        for(String code: codes)
            body +="\n"+code;
        return "<html>\n" +
                "<head>\n" +
                "<meta charset='UTF-8'> \n" +
                "<title>Chess.fsb</title>\n" +
                "<link rel='stylesheet' href='https://grh.alwaysdata.net/css/"+cssFile+".css' type='text/css'>\n" +
                "<link rel='preconnect' href='https://fonts.googleapis.com'>\n" +
                "<link rel='preconnect' href='https://fonts.gstatic.com' crossorigin>\n" +
                "<link href='https://fonts.googleapis.com/css2?family=Dancing+Script:wght@400;500;700&display=swap' rel='stylesheet'>"+
                "</head>\n" +
                "<body>\n" +
                body+
                "</body>\n" +
                "</html>";
    }
    public static String getMenuHtmlCode(){
        return "<div class='console'> \n" +
                "        <h1>Chess.fsb</h1>\n" +
                "        <a href='http://localhost:8088/create/'>create game</a>\n" +
                "        <div class='group-bi'>\n" +
                "            <input type='text' id='code'>\n" +
                "            <a class='disabled' id='linkJoin'>join game</a>\n" +
                "        </div>\n" +
                "    </div>";
    }
    public static String getScriptCode(){
        return " <script type='text/javascript'>\n" +
                "        document.getElementById('linkJoin').onclick = function() {\n" +
                "            const code= document.getElementById('code').value;\n" +
                "            this.setAttribute('href', 'http://localhost:8088/join/'+code+'/');\n" +
                "        }\n" +
                "    </script>";
    }
    public static String getIsCheckCode(){
        return "<div class='is-check'>\n" +
                "        CHECK\n" +
                "    </div>";
    }
    public static String getWinnerCode(){
        return "<div class='is-check vectory'>\n" +
                "        VECTORY\n" +
                "    </div>";
    }
    public static String getDefaultCode(){
        return "<div class='is-check default'>\n" +
                "        DEFAULT\n" +
                "    </div>";
    }
    public static String getScriptCodeClick(){
        return "<script type='text/javascript'>\n" +
                "        const queryString = window.location.href;\n" +
                "        const from= queryString.split('/').filter(t => t.match('^[1-8]_[1-8]$'));\n" +
                "        let squares= [];\n" +
                "        squares= document.getElementsByClassName('chessboard')[0].getElementsByTagName('div'); \n" +
                "         \n" +
                "        for(let i=0; i<squares.length; i++){ \n" +
                "                squares[i].onclick= function (){ \n" +
                "                    let a= document.createElement('a'); \n" +
                "                    const id_user= document.getElementById('id_user').value;\n" +
                "                    if(squares[i].style.backgroundColor==\"rgb(151, 165, 205)\")\n" +
                "                        a.href=`http://localhost:8088/move/${from}/${squares[i].id}/id-${id_user}/`;\n" +
                "                    else \n" +
                "                        a.href=`http://localhost:8088/click/${squares[i].id}/id-${id_user}/`; \n" +
                "                    a.click(); \n" +
                "            } \n" +
                "        }"+
                "</script>";
    }
    public static String getScriptBlueColor(){
        return "<script type='text/javascript'>\n" +
                "    const ids=document.getElementById('ids').value;\n" +
                "    let idsTab= ids.split('/');\n" +
                "    \n" +
                "    for(let i=0; i<idsTab.length; i++){\n" +
                "        document.getElementById(idsTab[i]).style.backgroundColor='#97a5cd';    \n" +
                "        document.getElementById(idsTab[i]).style.boxShadow = 'rgb(96 91 91) 0px 0px 20px 8px inset';"+
                "    }\n" +
                "</script>";
    }
    public static String getInputId(long id){
        return "<input type='number' name='id_user' id='id_user' value="+id+" style='display: none;'>";
    }
    public static String getInputIdS(List<String> ids){
        String flux="";
        for(String id: ids)
            flux +=id+"/";
        flux.substring(0, flux.length()-1);

        return "<input type='text' name='ids' id='ids' value="+flux+" style='display: none;'>";
    }
    public  static  String getStepConnection(String code, long id){
        return "<div class='console'> \n" +
                "        <h1>Chess.fsb</h1>\n" +
                "        <h2>Send This Code To Your Friend</h2>\n" +
                "        <h2>"+code+"</h2>\n" +
                "        <a href='http://localhost:8088/click/5_5/id-"+id+"/' class='start'>start game</a>\n" +
                "    </div>";
    }
    public static String joinReponseCode(String color, String msg, long id){
        return (id==-1)?"<div class='console'>\n" +
                "        <h1>Chess.fsb</h1>\n" +
                "        <h2 style='color: "+color+"'>"+msg+"</h2>\n" +
                "    </div>":
                "<div class='console'>\n" +
                "        <h1>Chess.fsb</h1>\n" +
                "        <h2 style='color: "+color+"'>"+msg+"</h2>\n" +
                        "<a href='http://localhost:8088/click/5_5/id-"+id+"/' class='start'>start game</a>\n" +
                "    </div>";
    }
    public static String generateCode(){
        int min=65;
        int max=90;
        int b;
        char[] listChar= new char[10];
        for(int i=0; i<8; i++){
            b = (int)(Math.random()*(max-min+1)+min);
            listChar[i]=(char)b;
        }
        return  MyString.correctString(listChar);

    }

}
