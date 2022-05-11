$otrosNombres = 0;
foreach($nombre in $(Get-Content -Path .\lista_nombres.txt)) {
    if ($nombre -eq "Juan") {
        Write-Output "Encontre a $nombre";
    } else {
        $otrosNombres++;
    }
}
Write-Output "La cantidad de nombres que no son Juan es $otrosNombres";