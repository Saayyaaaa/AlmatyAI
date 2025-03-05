**1. Склонируйте проект**
_Откройте терминал и выполните команду:_ git clone https://github.com/your-repository/AlmatyAI.git
Замените your-repository на реальный URL репозитория.
_Перейдите в папку проекта🥉_ cd AlmatyAI

**2. Откройте проект в Android Studio**
_Запустите Android Studio.
Выберите "Open" и откройте папку проекта.
Дождитесь, пока Gradle завершит синхронизацию._

**3. Добавьте API-ключ Google Maps**
_По соображениям безопасности ключ API не загружается в Git.
Чтобы приложение работало с картами, нужно добавить API-ключ вручную:_

_В папке app/src/main/res/values/ создайте файл google_maps_api.xml.
Добавьте в него следующий код:_

```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <string name="google_maps_key" translatable="false">ВАШ_API_КЛЮЧ</string>
</resources>```


_Вместо ВАШ_API_КЛЮЧ вставьте свой API-ключ._

**4. Установите зависимости**
_Если Gradle не подтянул зависимости автоматически, выполните в терминале:_

./gradlew build

_Или нажмите "Sync Project with Gradle Files" в Android Studio._

**5. Запустите приложение**
_Подключите эмулятор или физическое устройство.
В Android Studio нажмите Run (▶️) или выполните в терминале:_

./gradlew installDebug
