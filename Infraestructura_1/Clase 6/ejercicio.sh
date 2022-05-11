req=`curl https://raw.githubusercontent.com/olea/lemarios/master/nombres-propios-es.txt | shuf`
countA=0
countL=0
countD=0

for nombre in $req

do
if
         [[ $nombre == A* ]] && [ $countA -le 4 ] ;

then
        echo $nombre
        let "countA++"
        curl -s https://api.genderize.io/?name=$nombre | jq '.gender' | { read -r gen; echo "Gender of $nombre is: $gen"; }
        curl -s https://api.nationalize.io/?name=$nombre | jq '.country[0].country_id' | { read -r cn; echo "Country of $nombre$ is: $cn" ; }

elif

        [[ $nombre == L* ]] && [ $countL -le 4 ];


then
        echo $nombre
        let "countL++"
        curl -s https://api.genderize.io/?name=$nombre | jq '.gender' | { read -r gen; echo "Gender of $nombre is: $gen"; }
        curl -s https://api.nationalize.io/?name=$nombre | jq '.country[0].country_id' | { read -r cn; echo "Country of $nombre$ is: $cn" ; }

elif

        [[ $nombre != A* ]] && [[ $nombre != L* ]] && [ $countD -le 4 ] ;

then
        echo $nombre
        let "countD++"
        curl -s https://api.genderize.io/?name=$nombre | jq '.gender' | { read -r gen; echo "Gender of $nombre is: $gen"; }
        curl -s https://api.nationalize.io/?name=$nombre | jq '.country[0].country_id' | { read -r cn; echo "Country of $nombre$ is: $cn" ; }


fi
done