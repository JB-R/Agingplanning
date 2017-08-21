package tounzcompagny.agingplanning.Objects;

import tounzcompagny.agingplanning.R;

public enum State {
    EN_COURS(R.drawable.icon_in_progress), EN_ATTENTE(R.drawable.icon_waiting), TERMINER(R.drawable.icon_stop), FIN(R.drawable.icon_end);
    private int icon;

    public int getIcon() {
        return icon;
    }

    State(int icon) {
        this.icon = icon;
    }
}
