INSERT INTO Author(firstName, lastName) VALUES('Rafał', 'Ziemkiewicz');
INSERT INTO Author(firstName, lastName) VALUES('Stanisław', 'Michalkiewicz');
INSERT INTO Author(firstName, lastName) VALUES('Leszek', 'Żebrowski');
INSERT INTO Author(firstName, lastName) VALUES('Marcin', 'Iwuć');
INSERT INTO Author(firstName, lastName) VALUES('Maciej', 'Aniserowicz');

INSERT INTO Category(name, description) VALUES('finances','describing and commenting on the world of finance');
INSERT INTO Category(name, description) VALUES('politics','describing and commenting on the world of politics');
INSERT INTO Category(name, description) VALUES('history','history articles');
INSERT INTO Category(name, description) VALUES('programming','about programming');

INSERT INTO Article (content, title, updated, created, author_id) VALUES ('To naprawdę nie by', 'Koalicja obciachu', '2007-12-03', '2007-12-01', 1, 2);
INSERT INTO Article (content, title, updated, created, author_id) VALUES ('Rozmawiałem kiedyś z Władysławem Frasyniukiem - wiem, że brzmi to nieprawdopodobnie, ale, naprawdę, sięgam pamięcią takich czasów, kiedy z ludźmi dziś już kompletnie oszalałymi z nienawiści do PiS dało się normalnie rozmawiać. Frasyniuk był wtedy przewodniczącym chylącej się ku upadkowi Unii Wolności i utyskiwał, że na wszystkich spotkaniach z wyborcami tłumaczyć się musi z "Gazety Wyborczej". Bo dla ludzi - tych życzliwych mu, popierających, zamierzających na jego partię głosować - linią programową i ideologią Unii Wolności było to, co napisała wspomniana gazeta, a nie to, co sobie przegłosowali w dokumentach programowych czy zadeklarowali w innych mediach jej politycy, z przewodniczącym na czele', 'Medialne ogony merdają swymi psami', '2019-01-03', '2019-01-01', 4 );
INSERT INTO Article (content, title, updated, created, author_id) VALUES ('Jaką wiedzę na temat pieniędzy wynoszą Twoje dzieci ze szkoły? Głównie taką, że  pieniądze bierze się od rodziców! Na komitet rodzicielski, na kwiaty z okazji dnia nauczyciela, na wyjście do kina… W szkole nie ma przedmiotu finanse osobiste, więc cała nadzieja w Tobie. Ale uwaga! Jeżeli będziesz przeginać z edukacją finansową, to będą to dla dzieci kolejne „skwary” odciągające ich uwagę od ciekawszych spraw.','CZEGO I JAK UCZYĆ DZIECI O PIENIĄDZACH?', '2019-01-03T10:15:30', '2019-01-01T10:14:30', 1);
INSERT INTO Article (content, title, updated, created, author_id) VALUES ('Rząd „dobrej zmiany” aż się zachłysnął własną odwagą, wzywając do MSZ panią ambasadoressę bezcennego Izraela w Warszawie i odmawiając udziału w rendez-vous, jakie akurat w Izraelu wyznaczyli sobie członkowie Grupy Wyszehradzkiej. To oczywiście bardzo ładnie, że rząd „dobrej zmiany” jest zdolny do takiej brawury, o którą nigdy bym nie posądzał pana premiera Mateusza Morawieckiego. Ale – powiadają – jak Pan Bóg dopuści, to i z kija wypuści – więc dlaczego pan premier Mateusz Morawiecki nie miałby być mężny?','Za kulisami brawury', '2019-03-06T10:15:30', '2019-03-05T10:14:30', 2 );
INSERT INTO Article (content, title, updated, created, author_id) VALUES ('Bury poranek, szaruga i dziki wicher. Deszcz zacina poziomo, zdaje się zostawiać bruzdy na polikach. Wtaczasz się sfatygowany do biura, składasz parasol… i masz ochotę zakopać się pod stertą suchych liści i tam przeczekać do emerytury. Opatrzności, znowu to samo, dodaj mi sił…','Nie pożądaj pasji bliźniego swego…', '2019-03-06T10:15:30', '2019-03-05T10:14:30', 5);
INSERT INTO Article (content, title, updated, created, author_id) VALUES ('Z czym kojarzy Ci się określenie “budżet domowy”? Jeżeli pierwszym, co przyszło Ci do głowy jest nudne, żmudne i bezrefleksyjne zbieranie paragonów czy spisywanie najdrobniejszego wydatku, mam dla Ciebie dobrą wiadomość: możesz odetchnąć z ulgą. To nie o to chodzi.Dobrze zrobiony budżet domowy jest jednym z najlepszych narzędzi pomagających zadbać o własne finanse. Jest również narzędziem prostym i skutecznym. Bardzo łatwo zrozumiesz mechanizm jego działania, jeżeli tylko poświęcisz chwilę, by w swojej wyobraźni wcielić się w rolę pracodawcy, który… Zatrudnia swoje własne pieniądze.','FBO 049: JAK PRZYGOTOWAĆ ŚWIETNY BUDŻET DOMOWY?', '2019-03-06', '2019-03-05', 4 );
INSERT INTO Article (content, title, updated, created, author_id) VALUES ('I tak oto idea mądrego dbania o własne finanse zatacza coraz szersze kręgi.Co ciekawe, udaje mi się zarazić nią nie tylko Czytelników bloga, lecz także moich przyjaciół, znajomych, a nawet współpracowników. Wiem, że to działa – bo świetnie sprawdziło się w mojej rodzinie. A teraz zobaczcie, jakie zmiany w ciągu zaledwie sześciu miesięcy nastąpiły w życiu Justyny!','DLACZEGO WARTO PROWADZIĆ BUDŻET DOMOWY? 5 SUPER POZYTYWNYCH EFEKTÓW. WNIOSKI PO SZEŚCIU MIESIĄCACH OD STARTU', '2019-03-06', '2019-03-05', 4);
INSERT INTO Article_Category(Article_id,categories_id) VALUES (1,1);
INSERT INTO Article_Category(Article_id,categories_id) VALUES (2,2);
INSERT INTO Article_Category(Article_id,categories_id) VALUES (3,1);
INSERT INTO Article_Category(Article_id,categories_id) VALUES (4,2);
INSERT INTO Article_Category(Article_id,categories_id) VALUES (5,4);
INSERT INTO Article_Category(Article_id,categories_id) VALUES (6,1);



