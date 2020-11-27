export function getTableIconMap() {
    var icon_map = new Map([
        ["authoritylists", "AuthorityTableIcon"], 
        ["projectlists", "ProjectTableIcon"], 
        ["fundlists","FundsTableIcon"],
    ]);

    return icon_map;
}