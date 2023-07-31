class Planet {
    constructor(img, gravity) {
      this.img = img;
      // 중력 가속도 적용 meter/sec
      this.중력가속도 = gravity;
      this.groundHeight = 30;
    }

    땅그리기(ctx, canvasHeight) {
      ctx.drawImage(this.img, 0, canvasHeight - this.groundHeight);
    }

  }