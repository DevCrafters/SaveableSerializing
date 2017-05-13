### 현재 SaveableSerializing 시스템은 <font color = "green"> 불안정한 </font> 상태입니다.
> System Version 0.4.2 (<font color = "green"> Unstable </font>)<br>
## This system is aiming at serializing Java API up to 20%!<br>
> Current Progress : 0.46% ( 4 / 848 ) - Java 8<br>
## 이 시스템은 자바 API 20%의 직렬화를 목표로 하고 있습니다.<br>
> 현재 진행 상황 : 0.46% ( 4 / 848 ) - 자바 8
<br>
<br>
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


<br><br>
# SaveableSerializing System is...
<br>Text based serializing system focused on speed and readability.
<br>SaveableWriter executes serialization with like next format .
<br>
### start subset<br>
#### items<br>
### end subset<br>
<br><br>
SaveableReader basically allows 250 deep of inner class.
<br>This can change about create saveable object,<br>but we don't recommanded that because of over 250 section waste many memory.
<br>
<br>Basic package of project is milkyway.SaveableSerializing.Parser
<br>You can read Saveable Serialization after copy that package "to" your project. 
<br>ItemStack is Example Package, and contains ItemStack Serialization of lower 1.5.2 Minecraft ItemStack. 
<br>We will support higher 1.5.2 ItemStack Serialization, and we are in progress. 
<br>If you use lower 1.5.2 Serialization,ItemFlag can be ignored.
<br>If you want to use ItemStack Serialization,Copy milkyway.SaveableSerializing.ItemStacks on your package with Default Saveable project.
<br>
<br>
This system follows <strong>MIT Lisence</strong>.
<br>You are free at distribute and edit,and commercial use,
<br>but you must make the copyright notice and permission mark on all copies or important parts of the software.
<br>In addition, milkyway0308, the creator of this system, is not responsible for any problems with the use of the software without project bugs.
