package mvpmaster.lht.com.lht.ui.beanIml;

import java.util.List;

import mvpmaster.lht.com.lht.base.BaseBean;

/**
 * Created by Ly on 2016/11/3.
 */

public class NewsDetailBean extends BaseBean {

    /**
     * body : <div class="main-wrap content-wrap">
     <div class="headline">

     <div class="img-place-holder"></div>



     </div>

     <div class="content-inner">




     <div class="question">
     <h2 class="question-title">为什么万有引力定律，库伦定律都是平方反比？平方反比有什么含义吗？</h2>

     <div class="answer">

     <div class="meta">
     <img class="avatar" src="http://pic2.zhimg.com/62b41d825_is.jpg">
     <span class="author">wolray，</span><span class="bio">此刻的内心是窃喜的</span>
     </div>

     <div class="content">
     <p>题主抱怨老师「每次都敷衍地说是实验结论」，那么可能有两个含义：一是实验发现确实是 2，而不是 1 或者 3；二是实验发现数值刚好是 2，而不是 2.01 或者 1.99。对于后一种情况，在 Quora 上有更深入的回答，我会先结合它的重点和一些 wiki 百科的资料大概搬运下，然后在此基础上和大家讨论分享一些有意思的东西。另外，百度百科上也有一点内容，不过编辑太混乱不建议直接看。</p>
     <p><strong>首先，牛顿和库伦公式并不是精确的平方反比关系，也就是说这个 2，确确实实带有小数点。</strong></p>
     <p>对于万有引力，一个典型的例子是水星进动。早在 1859 年，就有一个法国的天文学家发现，水星每一个回归周期的进动角和牛顿定律计算出的数值差了 38 秒（角度），这个观测值后来又修正到了 43 秒。为了解释这个现象，有人提出理论解释说，万有引力公式中的平方反比关系应该修正为 2 加上某个很小的小数，也就是我们正在讨论的问题。除此以外，还有许多其他不成熟的理论，例如甚至有人猜想水星轨道内部还有一个更靠近太阳的神秘小行星&ldquo;火神星&rdquo;，总之一时间可谓众说纷纭。一直到 1915 年爱因斯坦提出了广义相对论之后，人们这才发现，原来水星进动角和牛顿定律的误差是可以用通过广义相对论进行修正的，修正值也是 43 秒左右，虽然修正之后依然存在误差，但误差已经小到了一个很小的程度，以至很多微弱的因素都会对其产生干扰，例如其他星体的摄动、太阳的扁率、设备误差等，实验上很难克服。</p>
     <p>当然，单说到这些，你确实可以认为平方反比律存在微小误差，即便它是受广义相对论的影响，好歹计算结果终归是符合的，可以说是一个合格的备选理论。后边我将具体解释广义相对论是怎么修正的，以及这个备选理论为什么不好。现在咱们先继续讨论库伦定律中的平方反比律。</p>
     <p>根据 Quora 中这位答主（MIT 物理本、Stanford 粒子物理 PhD）的回答，库伦定律同样不是精确的平方反比，而是比 2 稍微大了那么一点点。根据量子电动力学的看法，宇宙中的真空并不是真正一无所有的真空，由于量子涨落效应，真空中时时刻刻都有正负虚粒子对不断产生和湮灭，在强场情况下，这些虚粒子会对我们所观测的电荷造成一定程度的屏蔽效应，使得场强会有略微下降，反映到库伦平方反比定律里，就是这个 2 会稍稍变大一点。</p>
     <p>然而，注意了，下面是关键。<strong>尽管平方反比定律在强场情况下都存在微小的误差，但无论是广义相对论还是量子电动力学，在弱场极限下，或者说离场源无限远的地方，平方反比关系都会恢复为精确的，毫无哪怕一点误差的，整数 2。</strong></p>
     <p>&nbsp;</p>
     <p>介绍完这个背景，现在开始我们的正式讨论。（有点小激动，搓一搓手先。</p>
     <p>总结一下之前的结论，牛顿定律和库伦定律中的平方反比关系，在强场情况下，在数值上确实不是整数 2，而是比 2 大了一个很小很小的小数。前者是广义相对论效应引起的，后者是量子涨落效应。但无论怎样，当强场极限远处衰减为弱场之后，这个比例系数，最后一定会恢复为精确的 2。</p>
     <p>那么，对于这样一个事实，我们应该怎么去理解呢？这很显然涉及到宇宙一些本原的性质，是一个很有意义的课题，其理解的方式当然可以是多种多样的。看了一下这个题目下的许多答案，大部分都是在通过高斯公式中的通量守恒去论证平方反比关系，这样的回答自然没问题，也有确实利于人们理解，只不过有一个小缺点是， 高斯公式和平方反比在数学上原本就是完全等价的，这样的循环论证并没有提供更多的信息。</p>
     <p>当我们试图去理解一个物理现象时，过分沉迷于数学推导并不是一件好事，因为数学并不反映现实，它本身只是一个主观的逻辑体系，告诉你怎么从 A 走到 B，或者怎么从 B 回到 A，但它永远不会告诉你，为什么 A 就一定要长成 A 这个样子。</p>
     <p>放在这个语境下就是，为什么平方反比关系在弱场极限下，一定是精确的 2。或者更直接一点问，为什么宇宙一定要这么设计？</p>
     <p>这就是最好玩的地方了。<strong>在我个人看来</strong>，之所以会如此，是因为我们宇宙有一个非常非常 NICE 的性质：<strong>它不允许分数维度的存在。</strong></p>
     <p>我们都知道，长度单位&nbsp;<img class="content-image" src="http://www.zhihu.com/equation?tex=m" alt="" />&nbsp;用来度量一维空间，而&nbsp;<img class="content-image" src="http://www.zhihu.com/equation?tex=m%5E2" alt="" />&nbsp;则用于度量二维空间。那么现在我给你一个新的量纲，&nbsp;<img class="content-image" src="http://www.zhihu.com/equation?tex=m%5E%7B1.5%7D" alt="" />&nbsp;&mdash;&mdash;问，它能度量什么？</p>
     <p>我猜你可能会说，卧槽这不是日了狗吗！</p>
     <p>值得庆幸的是，&nbsp;<img class="content-image" src="http://www.zhihu.com/equation?tex=m%5E%7B1.5%7D" alt="" />&nbsp;这种分数维度下的量纲不仅在我们的物理体系中无法兼容，目前看起来我们的宇宙也不允许它的存在。</p>
     <p>我上学以来，见过的，推过的，听说过的所有物理公式，中间的每一个量纲都是整数次幂的，即便有时候会遇到类似于&nbsp;<img class="content-image" src="http://www.zhihu.com/equation?tex=r%5E%7B3%2F2%7D" alt="" />&nbsp;这种分数次幂项，它也一定会有一个分子或者分母相除或者直接放到等号另一边，从而消掉这额外多出来的&nbsp;<img class="content-image" src="http://www.zhihu.com/equation?tex=0.5" alt="" />&nbsp;个维度。</p>
     <p>为了对此进行深入讨论，不妨回到最初的水星进动问题。在广相出现之前，有人将观测误差归结为对牛顿定律中平方反比系数的修正，虽然修正之后的数值可以完美匹配观测值，但那位可敬的天文学家却忽略了一个很严重的问题：量纲不统一。</p>
     <p>万有引力公式是&nbsp;<img class="content-image" src="http://www.zhihu.com/equation?tex=g%3D%5Cfrac%7BGM%7D%7Br%5E2%7D" alt="" />&nbsp;，其中重力加速度&nbsp;<img class="content-image" src="http://www.zhihu.com/equation?tex=g" alt="" />&nbsp;的量纲是&nbsp;<img class="content-image" src="http://www.zhihu.com/equation?tex=m%2Fs%5E2" alt="" />&nbsp;，在引力常数&nbsp;<img class="content-image" src="http://www.zhihu.com/equation?tex=G" alt="" />&nbsp;和天体质量&nbsp;<img class="content-image" src="http://www.zhihu.com/equation?tex=M" alt="" />&nbsp;不变的前提下，假设将&nbsp;<img class="content-image" src="http://www.zhihu.com/equation?tex=r%5E2" alt="" />&nbsp;中的&nbsp;<img class="content-image" src="http://www.zhihu.com/equation?tex=2" alt="" />&nbsp;改成了&nbsp;<img class="content-image" src="http://www.zhihu.com/equation?tex=2.1" alt="" />，那么计算出来的重力加速度，其量纲就会变成&nbsp;<img class="content-image" src="http://www.zhihu.com/equation?tex=m%5E%7B0.9%7D%2Fs%5E2" alt="" />。</p>
     <p>这是什么鬼！</p>
     <p>它和正常的&nbsp;<img class="content-image" src="http://www.zhihu.com/equation?tex=m%2Fs%5E2" alt="" />&nbsp;是什么关系？&nbsp;<img class="content-image" src="http://www.zhihu.com/equation?tex=0.9m%2Fs%5E2" alt="" />&nbsp;和&nbsp;<img class="content-image" src="http://www.zhihu.com/equation?tex=1m%5E%7B0.9%7D%2Fs%5E2" alt="" />&nbsp;哪个更大一些？&nbsp;它乘以时间之后得到&nbsp;<img class="content-image" src="http://www.zhihu.com/equation?tex=m%5E%7B0.9%7D%2Fs" alt="" />，这又是什么鬼！是速度吗？显然不是。是不是可以管它叫亚速度？好像可以&mdash;&mdash;那亚速度又是什么物理意义？鬼知道！</p>
     <p>如果&nbsp;<img class="content-image" src="http://www.zhihu.com/equation?tex=m%5E%7B0.9%7D" alt="" />&nbsp;这种量纲能够成立，那么还有&nbsp;<img class="content-image" src="http://www.zhihu.com/equation?tex=m%5E%7B0.1%7D" alt="" />&nbsp;，<img class="content-image" src="http://www.zhihu.com/equation?tex=m%5E%7B0.8%7D" alt="" />，<img class="content-image" src="http://www.zhihu.com/equation?tex=m%5E%7B3.14%7D" alt="" />，<img class="content-image" src="http://www.zhihu.com/equation?tex=m%5E%7B2.333%7D" alt="" />&nbsp;等等一系列无穷无尽的分数维度等着你去定义。更糟糕的是，当你辛辛苦苦把它们挨个儿定义完了之后，却发现不同的维度之间哪怕只差了一个极其微小的小数，也绝对无法比较大小。</p>
     <p>当然，有人可能辩解说，&nbsp;<img class="content-image" src="http://www.zhihu.com/equation?tex=r%5E2" alt="" />&nbsp;改成&nbsp;<img class="content-image" src="http://www.zhihu.com/equation?tex=r%5E%7B2.1%7D" alt="" />&nbsp;没有问题，把引力常数&nbsp;<img class="content-image" src="http://www.zhihu.com/equation?tex=G" alt="" />&nbsp;同时也调一下不就行了，看起来似乎有理，然而问题在于这个平方反比的系数 2，它在不同距离上的误差漂移是不一样的，为了保证量纲匹配，引力常数&nbsp;<img class="content-image" src="http://www.zhihu.com/equation?tex=G" alt="" />&nbsp;的量纲也得跟着不断调整，既然如此，那这个&nbsp;<img class="content-image" src="http://www.zhihu.com/equation?tex=G" alt="" />&nbsp;如何还称得上基本常数？</p>
     <p>所以，文章最开始的表述其实是不对的，仅仅是卖了个关子。<strong>平方反比系数等于 2，是三维空间的必然，等于精确的整数 2，是物理维度不可分的必然。之所以在强场下会有观测误差，是因为场源（<img class="content-image" src="http://www.zhihu.com/equation?tex=M" alt="" />、<img class="content-image" src="http://www.zhihu.com/equation?tex=Q" alt="" />），或者也可以等效的认为是常数（<img class="content-image" src="http://www.zhihu.com/equation?tex=G" alt="" />、<img class="content-image" src="http://www.zhihu.com/equation?tex=%5Cepsilon_%7B0%7D" alt="" />），发生了畸变。</strong></p>
     <p><em>这么说其实只是为了便于理解。引入了相对论效应的引力场方程是很复杂的，解出来也不是单纯负幂数关系，而是多个不同幂数项的叠加，<strong>而其中每一项的量纲仍然都是整数，没有分数维度出现。所以把这个整数 2 理解为一个数值上的最佳拟合就好了。</strong></em></p>
     <p>有人可能会说，那分形呢，分形不就是分数维度吗。</p>
     <p>虽然我们确实在数学上通过分形理论构造出了所谓的分数维度，甚至还应用到了英国海岸线长度测量上，但在实际的真实物理世界里，并没有真正的严格意义上的分形。河流、叶脉、血管、雪花，这些东西虽然具有类分形的复杂结构，但它们远没有无穷的细节，所以可以用整数的维度进行完全的度量。比如说海岸线的长度测量，用&nbsp;<img class="content-image" src="http://www.zhihu.com/equation?tex=m" alt="" />&nbsp;就足够了，尽管在不同的精度要求下测出来的总长度会有所差异，但那只是工程近似问题，和分数维度其实没那么大的关系。分形意义上的分数维度本质上只是一种数学构造，反映的是物体对空间的不完全填充，和我们现在所讨论的物理维度问题，并不是一回事。</p>
     <p>假设你是负责某国海岸线测量的官员，测了半天发现怎么也测不准，于是整了套分形理论，向你上司汇报说：&ldquo;老板，测出来了！我朝的海岸线长度是&nbsp;<img class="content-image" src="http://www.zhihu.com/equation?tex=23333km%5E%7B1.26%7D" alt="" />！&rdquo;</p>
     <p>你老板会是什么表情。</p>
     <p>某个醉人的黄昏，你在吃完温馨的晚餐后对你老婆说，亲爱的咱们去海边散散步吧，健胃消食，看看夕阳也好。啊，其实倒也不用走太远&nbsp;<img class="content-image" src="http://www.zhihu.com/equation?tex=500+m%5E%7B1.26%7D" alt="" />&nbsp;就差不多了。</p>
     <p>你老婆会是什么表情。</p>
     <p>&nbsp;</p>
     <p>好了，玩笑归玩笑，说正经的。</p>
     <p>我们目前为止对世界的一切认识，以及由此建立起来的整个自然科学体系，从根本上说，来源于我们对世界的度量。世界之所以是可知的，首先在于它是可度量的。</p>
     <p><strong>在我看来</strong>，我们这个宇宙不允许分数维度的存在，实在是一件值得庆幸的事情。因为这样一来，我们就可以用有限的整数次幂的量纲，去度量我们所发现的每一个物理实体，并且不用担心不同次幂量纲之间物理量的渗透和泄露。</p>
     <p>之前看到某个回答下的一条评论，说，精确的平方反比关系说明没有物理量向其他维度泄露。这个说法很有意思，在 Quora 也有人提到过。咱们还是拿&nbsp;<img class="content-image" src="http://www.zhihu.com/equation?tex=m%5E%7B1.5%7D" alt="" />&nbsp;这个量纲来举例&mdash;&mdash;怎么看待多出的这&nbsp;<img class="content-image" src="http://www.zhihu.com/equation?tex=m%5E%7B0.5%7D" alt="" />&nbsp;？</p>
     <p>首先，它显然并不是一个完整的维度，但它确实又在一维之外占用了一点额外的维度。你说是有物理量泄露到额外的维度中去了，这样讲应该没错。不过需要明确的是，这里的&ldquo;额外的维度&rdquo;并不是某个神秘的未知维度，而是一维之外的第二维（因为 1.5 就介于 1 和 2 之间），这很可能也就意味着，两个原本独立的空间维度之间，出现了耦合！</p>
     <p>这简直就是人类物理学的灾难，三体入侵末日降临！如果空间维度不独立，那么所有和对称性相关的基本守恒律，空间平移不变性、空间旋转不变性、乃至时间平移不变性，恐怕都得推翻重写。麦克斯韦方程中，电场和磁场的旋度要加上空间耦合项，高斯定理瘫痪，电磁场的散度将不再是独立于空间的常数，电磁波这玩意儿还有没有都得另说。量子力学恐怕得加上新的非对易算符，薛定谔当时就傻了，海森堡吓得整个人都不太好。至于依赖于自由度能均分定理的热力学体系，直接轰然崩塌碎成一地。更糟糕的是，宇宙的造物之神为了维持时空的统一性，不得不为每一个多出来的小于 1 的分数维度，分配一个对应的光速。</p>
     <p>假设宇宙是一个模拟器，这位造物之神为了防止玩家跑得太快太远地图刷新跟不上，所以设置了光速壁垒，同时也为了避免他们观测到太微观的层面发现一切原本是虚无，所以设置了量子力学壁垒强行烧脑。那么分数维度这种东西一旦搞出来估计人家会陷入绝望抱着服务器一块儿自爆。试想如果连维度都不独立了，那树结构怎么办，矩阵怎么办，程序特么还怎么跑！</p>
     <p>&nbsp;</p>
     <p>很久没写这么长的文章，主要内容也说得差不多了。现在具体来解释下万有引力的广义相对论修正大概是怎么回事。</p>
     <p>假设你和你朋友站在离太阳 10 米的位置，你保持原地不动，你朋友向太阳走了 1 米。在你看来他确实走了 1 米，可是他自己却以为自己走了不止 1 米。你看他接着往前走，又走了 2 米，3 米，但是他却发现自己和你的距离要比 2 米，3 米更远。这是一件很奇怪的事情，同样是一根线段的两头，观察到的距离竟变得不一样了。不止如此，当他向前走的越远，你会发现他的速度越来越慢，不仅速度变慢了，连他整个人的肢体动作都变慢了，整个画面看起来就好像点了缓速播放一样；可是在他的眼里，你却像按了快进键一样，上蹿下跳动作夸张。</p>
     <p>之所以会这样，是因为度规发生了改变。你离太阳远，度规是正常的，他离太阳近，度规就会被压缩。所谓&ldquo;度规&rdquo;直观来讲就是他眼里的 1 米在你眼里要比 1 米更短，而你眼里的 1 米在他看来却比 1 米更长，不同长度的 1 米除以相同的光速，得到的时间也不一样，所以时间的流速也改变了。</p>
     <p>放在水星进动问题上。天文观测得出水星到太阳的距离是这么多，可是由于相对论效应，对于场源的太阳而言水星离它的距离要比我们以为的稍远一些，所以相应的实际引力会比计算值偏小，平方反比律才因此出现了误差，看起来就好像这个指数 2 要大一点才能匹配。</p>
     <p>以上。</p>
     <p>&nbsp;</p>
     <p>关于评论里很多人提到的循环论证问题，我确实得承认自己也是在循环论证，或者更准确的说是在循环讨论，要论严谨性的话其实谈不上论证。</p>
     <p>这可以引出一个更有意思的话题，<strong>是不是所有的物理规律都能找到更基础更底层的解释呢？</strong>就像个求知欲旺盛的小孩一样，把&ldquo;为什么&rdquo;永远问下去。</p>
     <p>答案是否定的。人类这一百多年来所取得的伟大科学成就有时候容易给人一种错觉，好像科学可以无限制的永远深入研究下去，以至于终有一天我们能解开宇宙一切奥秘上天入地改写时空无所不能。</p>
     <p>很遗憾，这只是一个美好的幻想。<strong>科学研究是会触顶的</strong>，目前为止我们发现的许多宇宙的基本性质，或者更直接一点讲，基本常数：万有引力常数、真空介电常数、光速等等，我们只能靠实验手段把它们测的越来越精确，或者发现它们亿万年来演变的蛛丝马迹，但是我们<strong>永远，注意是永远</strong>，<strong>无法严格证明</strong>为什么它们一定就要存在。我们只能在主观上（或者说数学上）找到各种各样的解释，用一种自己能接受的方式去理解大概是怎么回事。</p>
     <p>这就像是一个物理学版的哥德尔不完备定理：既然我们身处这个宇宙，就不可能真正跳到它外面去证明关于它的一切。</p>
     <p><em>Reference：</em></p>
     <p>Quora:&nbsp;<a href="https://www.quora.com/How-do-we-know-that-the-inverse-square-laws-of-physics-are-accurate">How do we know that the inverse square laws of physics are accurate?</a></p>
     <p>Wiki:&nbsp;<a href="https://en.wikipedia.org/wiki/Tests_of_general_relativity#Perihelion_precession_of_Mercury">Tests of general relativity</a></p>
     <p>百度：&nbsp;<a href="http://baike.baidu.com/link?url=bcYzT5yAEfI4iCU2PIeKLIRt5GyAAeorkoAz2xCoBWcsKtodyEKM6AcXrmCtQ3yPWdctmeMb2c_vsazANHRDQa">水星近日点进动问题</a></p>
     <p><em>既然评论里提到了引力场方程，那就再把相关的 wiki 链接放上来，感兴趣的可以看下。场方程不用自己解，看下几个主要解的形式就好。</em></p>
     <p><em>Wiki:<a href="https://en.wikipedia.org/wiki/Gravity">https://en.wikipedia.org/wiki/Gravity</a></em></p>
     </div>
     </div>


     <div class="view-more"><a href="http://www.zhihu.com/question/37340129">查看知乎讨论<span class="js-question-holder"></span></a></div>

     </div>


     </div>
     </div>
     * image_source : ESO/L. Calçada / CC BY
     * title : 米是长度，平方米是面积，那米的 1.5 次方呢？
     * image : http://pic3.zhimg.com/29cb91234f5620f36abadeb249bf015e.jpg
     * share_url : http://daily.zhihu.com/story/8943534
     * js : []
     * ga_prefix : 110311
     * images : ["http://pic3.zhimg.com/e840013a1c538a624c8909c8497e007a.jpg"]
     * type : 0
     * id : 8943534
     * css : ["http://news-at.zhihu.com/css/news_qa.auto.css?v=4b3e3"]
     */

    private String body;
    private String image_source;
    private String title;
    private String image;
    private String share_url;
    private String ga_prefix;
    private int type;
    private int id;
    private List<?> js;
    private List<String> images;
    private List<String> css;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImage_source() {
        return image_source;
    }

    public void setImage_source(String image_source) {
        this.image_source = image_source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getGa_prefix() {
        return ga_prefix;
    }

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<?> getJs() {
        return js;
    }

    public void setJs(List<?> js) {
        this.js = js;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<String> getCss() {
        return css;
    }

    public void setCss(List<String> css) {
        this.css = css;
    }
}
