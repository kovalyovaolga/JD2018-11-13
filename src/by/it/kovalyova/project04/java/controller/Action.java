package by.it.kovalyova.project04.java.controller;

import javax.servlet.http.HttpServletRequest;

enum  Action {

    RESET(new CmdReset()),
    TABLE(new СmdTable()),
    INDEX(new CmdIndex()),
    CREATEAD(new CmdCreateAd()),
    LOGIN(new CmdLogin()),
    PROFILE(new CmdProfile()),
    SIGNUP(new CmdSignup()),
    ERROR(new CmdError());

    Cmd cmd;
    Action(Cmd cmdIndex) {
        cmd=cmdIndex;
        }


    String getJsp() {
        return "/" + this.name().toLowerCase() + ".jsp";
    }



    static Action define(HttpServletRequest req){
        Action result=Action.INDEX;
        String command = req.getParameter("command");
        if (command!=null && !command.isEmpty()){
            try {
                result=Action.valueOf(command.toUpperCase());
            }
            catch (IllegalArgumentException e){
                //create our error
            }

        }
        return result;
    }
}
