package fr.campus_numerique.module_java.d_d.stats;

public class InteractionEvent {
    private String caseInfo;
    private boolean isPlayerAlive;
    private int casePosition;

    private String playerName;



    public InteractionEvent(String caseInfo, boolean isPlayerAlive, int casePosition, String playerName) {
        this.caseInfo = caseInfo;
        this.isPlayerAlive = isPlayerAlive;
        this.casePosition = casePosition;
        this.playerName = playerName;
    }

    public String getCaseInfo() {
        return caseInfo;
    }

    public boolean isPlayerAlive() {
        return isPlayerAlive;
    }
    public int getCasePosition() {
        return casePosition;
    }
    public String getPlayerName() {
        return playerName;
    }
}
