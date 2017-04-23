# SaveableSerializing 시스템은,
<br>가독성을 최대화시키고 속도를 중점에 둔 텍스트 기반 직렬화 시스템입니다.
<br>start subset ~~ end subset  형식으로 직렬화의 입력과 출력을 실행하며,
<br> 내부 직렬화 오브젝트를 허용하기 때문에 더욱 넓은 사용이 가능합니다.
<br> SaveableReader은 최대 250개의 내부 직렬화 오브젝트 깊이를 허용하며,
<br> SaveableReader 객체 생성 시에 추가적으로 깊이 설정이 가능하지만 250 깊이 이상의
<br> 오브젝트 깊이는 메모리가 상당히 낭비되기에 권장하지 않습니다.
<br>
<br> 프로젝트 기본 패키지는 milkyway.SaveableSerializing.Parser이며,
<br> 이 패키지를 복사할 때부터 Saveable 직렬화 방식 사용이 가능합니다.
<br>ItemStacks 패키지는 예제 패키지이며,
<br>1.5.2 이하 버전의 ItemStack 직렬화를 포함하고 있습니다.
<br> 1.6 이상에서 해당 직렬화를 사용시 아이템 플래그가 무시되니 주의해주세요.
<br>1.5.2 이하 버전 ItemStack 직렬화는 milkyway.SaveableSerializing.ItemStacks 패키지를
<br>위의 패키지와 같이 복사해주시면 사용이 가능합니다.
<br> 1.6 이상 ItemStack 직렬화는 곧 업데이트될 예정입니다.
<br>
<br>이 시스템은 MIT 라이센스를 따릅니다.
<br>수정,배포가 자유로우며 실무 혹은 상업적으로 이용이 허용되지만,
<br>저작권 표시 및 허가 표시를 소프트웨어의 모든 복제물 혹은 중요한 부분에 작성해야 합니다.
<br>또한,이 시스템의 제작자 milkyway0308은 소프트웨어 사용 관련해서 발생하는 문제에 책임을 지지 않습니다.
