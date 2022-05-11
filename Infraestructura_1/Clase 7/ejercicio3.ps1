$req = Invoke-WebRequest -Method Get -Uri <urlAlListado>
$nombresConA = $req.Content.split("`n") | Where-Object { $_ -like
"A*" }
1..5 | ForEach-Object {
$random = Get-Random -Minimum 0 -Maximum $($nombresConA.count-1)
$nombresConA[$random]
}
