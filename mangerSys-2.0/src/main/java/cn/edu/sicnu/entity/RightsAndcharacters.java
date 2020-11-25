package cn.edu.sicnu.entity;
public class RightsAndcharacters {
    private String characterId;

    private String rightAndCharactersId;

    private String cnote;

    private String id;

    private String name;

    private Integer abscissa;

    private Integer ordinate;

    private String urlPath;

    private String rnote;

    public RightsAndcharacters() {
    }

    public RightsAndcharacters(String characterId, String rightAndCharactersId, String cnote, String id, String name, Integer abscissa, Integer ordinate, String urlPath, String rnote) {
        this.characterId = characterId;
        this.rightAndCharactersId = rightAndCharactersId;
        this.cnote = cnote;
        this.id = id;
        this.name = name;
        this.abscissa = abscissa;
        this.ordinate = ordinate;
        this.urlPath = urlPath;
        this.rnote = rnote;
    }

    public String getCharacterId() {
        return characterId;
    }

    public void setCharacterId(String characterId) {
        this.characterId = characterId;
    }

    public String getRightAndCharactersId() {
        return rightAndCharactersId;
    }

    public void setRightAndCharactersId(String rightAndCharactersId) {
        this.rightAndCharactersId = rightAndCharactersId;
    }

    public String getCnote() {
        return cnote;
    }

    public void setCnote(String cnote) {
        this.cnote = cnote;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAbscissa() {
        return abscissa;
    }

    public void setAbscissa(Integer abscissa) {
        this.abscissa = abscissa;
    }

    public Integer getOrdinate() {
        return ordinate;
    }

    public void setOrdinate(Integer ordinate) {
        this.ordinate = ordinate;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    public String getRnote() {
        return rnote;
    }

    public void setRnote(String rnote) {
        this.rnote = rnote;
    }

    @Override
    public String toString() {
        return "RightsAndcharacters{" +
                "characterId='" + characterId + '\'' +
                ", rightAndCharactersId='" + rightAndCharactersId + '\'' +
                ", cnote='" + cnote + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", abscissa=" + abscissa +
                ", ordinate=" + ordinate +
                ", urlPath='" + urlPath + '\'' +
                ", rnote='" + rnote + '\'' +
                '}';
    }
}
