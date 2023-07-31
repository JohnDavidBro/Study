class Ball {
  /** 크기 (전부 사람 머릿속 생각 위주로 우선 세팅) */
  constructor(radius) {
    this.radius = radius;
    /** 현재 속도 */
    this.vX = 0;
    this.vY = 0;
  }

  /** 공 담아라. 공 준비해라 */
  위치지정(posX, posY) {
    this.posX = posX;
    this.posY = posY;
  }

  발사(ballVx, ballVy) {
    alert = "발사"
    this.vX = ballVx;
    this.vY = ballVy;
  }

  그리기간격(timeInterval) {
    this.timeInterval = timeInterval;
  }
  시간흐름() {
    // 중력 가속도.
    this.vY += 1.98;

    //수평 등속 운동.
    this.posX += this.vX;
    this.posY += this.vY;
  }

  맞췄니(target) {
    return target.inXBound(this.posX)
    && target.inYBound(this.posY);
  }

  /* 공을 화면에 그린다. */
  drawBall(ctx) {
    ctx.beginPath();
    ctx.arc(this.posX, this.posY, this.radius, 0, 2.0 * Math.PI, true);
    ctx.fillStyle = "#000000";
    ctx.fill();
  }

}